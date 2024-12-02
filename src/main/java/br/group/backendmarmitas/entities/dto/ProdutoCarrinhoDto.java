package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Produto;

public class ProdutoCarrinhoDto {
    private ProdutoDTO produto;
    private int quantidade;

    public ProdutoCarrinhoDto(ProdutoDTO produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoCarrinhoDto() {
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
