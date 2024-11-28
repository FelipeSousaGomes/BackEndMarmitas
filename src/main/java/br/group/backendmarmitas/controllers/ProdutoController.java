package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import br.group.backendmarmitas.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        ProdutoDTO produto = service.findById(id);
        return  ResponseEntity.ok(produto);
    }

   @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){

        List<ProdutoDTO> dto =service.findAll();
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<ProdutoDTO >insert( @RequestBody ProdutoDTO dto){

        dto =  service.Insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping (value = "/{id}")
    public ResponseEntity<ProdutoDTO> Update(@PathVariable Long id,@RequestBody ProdutoDTO dto){
        dto = service.Update(id,dto);
        return  ResponseEntity.ok(dto);
    }


    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
