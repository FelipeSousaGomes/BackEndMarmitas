package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Produto;

public class ProdutoCarrinhoDto {
    private Produto produto;
    private int quantidade;

    public ProdutoCarrinhoDto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoCarrinhoDto() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
