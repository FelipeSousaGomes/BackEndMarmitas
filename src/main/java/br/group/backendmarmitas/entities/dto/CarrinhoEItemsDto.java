package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Carrinho;
import br.group.backendmarmitas.entities.Produto;

import java.util.List;

public class CarrinhoEItemsDto {
    private CarrinhoDto carrinho;
    private List<ProdutoCarrinhoDto> produtos;

    public CarrinhoEItemsDto(CarrinhoDto carrinho, List<ProdutoCarrinhoDto> produtos) {
        this.carrinho = carrinho;
        this.produtos = produtos;
    }

    public CarrinhoEItemsDto() {
    }

    public CarrinhoDto getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDto carrinho) {
        this.carrinho = carrinho;
    }

    public List<ProdutoCarrinhoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCarrinhoDto> produtos) {
        this.produtos = produtos;
    }
}
