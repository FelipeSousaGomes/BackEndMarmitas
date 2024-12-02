package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.dto.EnvioRotasDto;
import br.group.backendmarmitas.entities.dto.ReceberRotasDto;
import br.group.backendmarmitas.services.RotasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "RotasController", description = "Controller responsável pelas operações de Rota do Usuário")
@RestController
@RequestMapping("/rotas")
public class RotasController {

    @Autowired
    private RotasService rotasService;

    @Operation(summary = "Enviar rotas", description = "Envia as rotas para o entregador, recebendo um DTO com as informações necessárias.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rotas enviadas com sucesso",
                    content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = EnvioRotasDto.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao processar as rotas",
                    content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @PostMapping("/")
    public EnvioRotasDto rotas(@Valid @RequestBody ReceberRotasDto dto) {
        System.out.println("Controller : " + rotasService.enviarRotas(dto));
        return rotasService.enviarRotas(dto);
    }
}
