package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.dto.UserDTO;
import br.group.backendmarmitas.services.UserService;
import br.group.backendmarmitas.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "UserController", description = "Controller responsável pelas operações de Usuário")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Get user by ID", description = "This endpoint retrieves the user information by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO usuario = service.findById(id);
        return  ResponseEntity.ok(usuario);
    }

    @Operation(summary = "Get all users", description = "This endpoint retrieves a list of all users.")
    @ApiResponse(responseCode = "200", description = "Users found successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class)))
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
