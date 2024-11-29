package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.ItemPedido;

public class ItemPedidoDTO {

    private Long produtoid;
    private Integer quantidade;
    private Double preco;
    private String imagem;

    public ItemPedidoDTO() {}

    public ItemPedidoDTO(ItemPedido itemPedido){
        this.produtoid = itemPedido.getProduto().getId();
        this.quantidade = itemPedido.getQuantidade();
        this.preco = itemPedido.getPreco();
        this.imagem = itemPedido.getProduto().getImage();
    }

    public Long getProdutoid() {
        return produtoid;
    }

    public void setProdutoid(Long produtoid) {
        this.produtoid = produtoid;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getSubTotal(){
        return preco*quantidade;
    }

}
