package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Endereco;
import br.group.backendmarmitas.entities.dto.EnderecoDTO;
import br.group.backendmarmitas.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@Tag(name = "EnderecoController", description = "Controller responsável pelas operações de cadastro de Endereço")
@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @Operation(summary = "Buscar endereço por ID", description = "Retorna os detalhes de um endereço específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado",
                    content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        EnderecoDTO endereco = service.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @Operation(summary = "Buscar todos os endereços", description = "Retorna uma lista de todos os endereços cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de endereços",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoDTO.class)))
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        List<EnderecoDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Buscar endereços por usuário", description = "Retorna uma lista de endereços associados a um usuário específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de endereços encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum endereço encontrado para o usuário",
                    content = @Content)
    })
    @GetMapping("/usuario/{idUsuario}")
    public List<EnderecoDTO> findByUsuario(@PathVariable Long idUsuario) {
        return service.findByUserId(idUsuario);
    }

    @Operation(summary = "Adicionar um novo endereço", description = "Cria um novo endereço para o usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO dto) {
        dto = service.Insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(summary = "Atualizar um endereço", description = "Atualiza as informações de um endereço existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado",
                    content = @Content)
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO dto) {
        dto = service.Update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Excluir um endereço", description = "Remove um endereço específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Endereço excluído com sucesso",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado",
                    content = @Content)
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
