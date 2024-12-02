package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Entregador;
import br.group.backendmarmitas.entities.dto.EntregadorDTO;
import br.group.backendmarmitas.services.EntregadorService;
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
@Tag(name = "EntrgadorController", description = "Controller responsável pelas operações de busca do Entregador")
@RestController
@RequestMapping(value = "/entregador")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @Operation(summary = "Buscar entregador por ID", description = "Retorna os detalhes de um entregador específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entregador encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntregadorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Entregador não encontrado",
                    content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<EntregadorDTO> findById(@PathVariable Long id) {
        EntregadorDTO entregador = entregadorService.findById(id);
        return ResponseEntity.ok(entregador);
    }

    @Operation(summary = "Buscar todos os entregadores", description = "Retorna uma lista de todos os entregadores cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de entregadores",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EntregadorDTO.class)))
    @GetMapping
    public ResponseEntity<List<EntregadorDTO>> findAll() {
        return ResponseEntity.ok(entregadorService.findAll());
    }
}
