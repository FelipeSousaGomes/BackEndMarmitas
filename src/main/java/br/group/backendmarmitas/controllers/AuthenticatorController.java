package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.dto.AuthenticatorDTO;
import br.group.backendmarmitas.entities.dto.RegisterDTO;
import br.group.backendmarmitas.entities.dto.UserDTO;
import br.group.backendmarmitas.infra.Security.TokenService;
import br.group.backendmarmitas.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "AuthenticatorController", description = "Controller responsável pelas operações de autenticação")
@RestController
@RequestMapping("/auth")
public class AuthenticatorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Operation(summary = "Login de usuário", description = "Autentica um usuário e retorna um token junto com os dados do usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))),
            @ApiResponse(responseCode = "400", description = "Credenciais inválidas",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody @Valid AuthenticatorDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);

        UserDTO userData = new UserDTO(user);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userData);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Registrar novo usuário", description = "Cria um novo usuário no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuário já existente",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO dto) {
        if (this.repository.findByEmail(dto.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());

        User newUser = new User(dto.email(), encryptedPassword, dto.role(), dto.telefone(), dto.CPF(), dto.nome());
        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
