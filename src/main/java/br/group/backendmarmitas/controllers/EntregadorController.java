package br.group.backendmarmitas.controllers;


import br.group.backendmarmitas.entities.Entregador;
import br.group.backendmarmitas.entities.dto.EnderecoDTO;
import br.group.backendmarmitas.entities.dto.EntregadorDTO;
import br.group.backendmarmitas.services.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/entregador")
public class EntregadorController {


    @Autowired
    private EntregadorService entregadorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntregadorDTO> findById(@PathVariable Long id){
        EntregadorDTO entregador = entregadorService.findById(id);
        return  ResponseEntity.ok(entregador);
    }

    @GetMapping
    public ResponseEntity<List<EntregadorDTO>> findAll(){
        return ResponseEntity.ok(entregadorService.findAll());
    }
}
