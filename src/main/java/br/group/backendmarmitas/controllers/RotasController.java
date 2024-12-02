package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.dto.EnvioRotasDto;
import br.group.backendmarmitas.entities.dto.ReceberRotasDto;
import br.group.backendmarmitas.services.RotasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotas")
public class RotasController {

    @Autowired
    private RotasService rotasService;
    @PostMapping("/")
    public EnvioRotasDto rotas(@Valid @RequestBody ReceberRotasDto dto){
        System.out.println("Controller : " + rotasService.enviarRotas(dto));
        return rotasService.enviarRotas(dto);
    }


}
