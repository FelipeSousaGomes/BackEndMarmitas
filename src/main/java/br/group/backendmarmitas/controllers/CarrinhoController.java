package br.group.backendmarmitas.controllers;

import br.group.backendmarmitas.entities.Carrinho;
import br.group.backendmarmitas.entities.dto.SalvarCarrinhoDto;
import br.group.backendmarmitas.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Autowired
    private CarrinhoService carrinhoService;
    @PostMapping("/")
    public Carrinho salvar(@RequestBody SalvarCarrinhoDto carrinho) {
        return carrinhoService.salvar(carrinho);
    }
}
