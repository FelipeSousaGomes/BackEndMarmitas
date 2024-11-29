package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Endereco;

public class EnderecoDTO {

    private Long id;
    private String rua;
    private String cep;
    private String descricao;
    private String complemento;
    private Integer numero;

    private Long userId;

    public EnderecoDTO() {}

    public EnderecoDTO(Long id, String rua, String cep,String descricao, String complemento, Integer numero, Long userId) {
        this.id = id;
        this.descricao = descricao;
        this.rua = rua;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.userId = userId;
    }

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.descricao = endereco.getDescricao();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
        this.userId = endereco.getUser() != null ? endereco.getUser().getId() : null; //
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
