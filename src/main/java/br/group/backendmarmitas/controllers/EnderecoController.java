package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.dto.EnderecoDTO;

import br.group.backendmarmitas.services.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id){
        EnderecoDTO endereco = service.findById(id);
        return  ResponseEntity.ok(endereco);
    }

   @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll(){

        List<EnderecoDTO> dto =service.findAll();
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<EnderecoDTO >insert( @RequestBody EnderecoDTO dto){

        dto = service.Insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping (value = "/{id}")
    public ResponseEntity<EnderecoDTO> Update(@PathVariable Long id,@RequestBody EnderecoDTO dto){
        dto = service.Update(id,dto);
        return  ResponseEntity.ok(dto);
    }


    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
