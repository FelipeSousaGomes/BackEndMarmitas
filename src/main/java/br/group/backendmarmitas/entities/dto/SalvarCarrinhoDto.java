package br.group.backendmarmitas.entities.dto;

public class SalvarCarrinhoDto {
    private Long id_usuario;
    private Long id_produto;

    public SalvarCarrinhoDto(Long id_usuario, Long id_produto) {
        this.id_usuario = id_usuario;
        this.id_produto = id_produto;
    }

    public SalvarCarrinhoDto() {}

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }
}
