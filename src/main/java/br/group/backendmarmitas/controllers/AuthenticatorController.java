package br.group.backendmarmitas.controllers;


import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.dto.AuthenticatorDTO;
import br.group.backendmarmitas.entities.dto.RegisterDTO;
import br.group.backendmarmitas.infra.Security.TokenService;
import br.group.backendmarmitas.repositories.UserRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping("auth")
public class AuthenticatorController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticatorDTO dto){
        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.email(),dto.senha());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return  ResponseEntity.ok(token);
    }

    @PostMapping ("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto ){
        if(this.repository.findByEmail(dto.email()) != null)return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());

        User newUser = new User(dto.email(),encryptedPassword,dto.role(),dto.telefone(),dto.CPF(), dto.nome());
        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
