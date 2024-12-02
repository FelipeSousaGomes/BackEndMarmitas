package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Carrinho;
import br.group.backendmarmitas.entities.dto.CarrinhoEItemsDto;
import br.group.backendmarmitas.entities.dto.SalvarCarrinhoDto;
import br.group.backendmarmitas.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Autowired
    private CarrinhoService carrinhoService;
    @PostMapping("/")
    public Carrinho salvar(@RequestBody SalvarCarrinhoDto carrinho) {
        return carrinhoService.salvar(carrinho);
    }

    @GetMapping("/{idUsuario}")
    public CarrinhoEItemsDto pegarCarrinhoEItensPorUsuario(@PathVariable Long idUsuario){
        return carrinhoService.pegarCarrinhoEItensPorUsuario(idUsuario);
    }

}
