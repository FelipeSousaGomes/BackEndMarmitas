package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.dto.PedidoDTO;
import br.group.backendmarmitas.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "PedidoController", description = "Controller responsável pelas operações de pedido de marmitas")
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Buscar pedido por ID", description = "Retorna os detalhes de um pedido específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
                    content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) {
        PedidoDTO dto = pedidoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Criar um novo pedido", description = "Cria um novo pedido e retorna os dados do pedido inserido.")
    @ApiResponse(responseCode = "201", description = "Pedido criado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class)))
    @PostMapping("/")
    public ResponseEntity<PedidoDTO> insert(@Valid @RequestBody PedidoDTO dto) {
        dto = pedidoService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(summary = "Atualizar pedido existente", description = "Atualiza um pedido existente pelo ID e retorna os dados atualizados.")
    @ApiResponse(responseCode = "200", description = "Pedido atualizado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class)))
    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> update(@Valid @RequestBody PedidoDTO dto, @PathVariable Long id) {
        dto = pedidoService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Listar pedidos por usuário", description = "Retorna uma lista de pedidos realizados por um usuário específico.")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class)))
    @GetMapping("/usuario/{idUsuario}")
    public List<PedidoDTO> listaPedidosPorUsuario(@PathVariable Long idUsuario) {
        return pedidoService.listaPedidosPorUsuario(idUsuario);
    }

    @Operation(summary = "Listar todos os pedidos", description = "Retorna uma lista de todos os pedidos registrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class)))
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        List<PedidoDTO> dto = pedidoService.findAll();
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Deletar pedido", description = "Deleta um pedido específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado", content = @Content)
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
