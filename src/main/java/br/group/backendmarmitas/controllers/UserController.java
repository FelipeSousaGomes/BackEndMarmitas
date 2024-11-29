package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.dto.AuthenticatorDTO;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import br.group.backendmarmitas.entities.dto.UserDTO;
import br.group.backendmarmitas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO usuario = service.findById(id);
        return  ResponseEntity.ok(usuario);
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<UserDTO> dto =service.findAll();
        return ResponseEntity.ok(dto);
    }
}
