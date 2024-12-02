package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Carrinho;
import br.group.backendmarmitas.entities.dto.CarrinhoEItemsDto;
import br.group.backendmarmitas.entities.dto.SalvarCarrinhoDto;
import br.group.backendmarmitas.services.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CarrinhoController", description = "Controller responsável pelas operações do carrinho de compra")
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Operation(summary = "Salvar um carrinho", description = "Cria um novo carrinho para o usuário com os itens fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrinho salvo com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content)
    })
    @PostMapping("/")
    public Carrinho salvar(@RequestBody SalvarCarrinhoDto carrinho) {
        return carrinhoService.salvar(carrinho);
    }

    @Operation(summary = "Buscar carrinho e itens por usuário", description = "Retorna o carrinho e os itens de um usuário específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho e itens encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarrinhoEItemsDto.class))),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado para o usuário",
                    content = @Content)
    })
    @GetMapping("/{idUsuario}")
    public CarrinhoEItemsDto pegarCarrinhoEItensPorUsuario(@PathVariable Long idUsuario) {
        return carrinhoService.pegarCarrinhoEItensPorUsuario(idUsuario);
    }
}
