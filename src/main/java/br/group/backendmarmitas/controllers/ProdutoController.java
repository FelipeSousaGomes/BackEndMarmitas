package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto = service.findById(id);
        return  ResponseEntity.ok(produto);
    }

  /*  @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAll(@RequestParam(name = "name" ,defaultValue = "")
                                                       String name , Pageable pageable){

        Page<ProductMinDTO> dto =service.findAll(name,pageable);
        return ResponseEntity.ok(dto);
    } */


    @PostMapping
    public ResponseEntity<Produto >insert( @RequestBody Produto produto){

        produto =  service.Insert(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

 /*   @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping (value = "/{id}")
    public ResponseEntity<ProductDTO> Update(@PathVariable Long id,@RequestBody ProductDTO dto){
        dto = service.Update(id,dto);
        return  ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }   */
}
