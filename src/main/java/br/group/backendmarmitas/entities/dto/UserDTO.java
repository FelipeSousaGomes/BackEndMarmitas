package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.User;

public class UserDTO {

    private Long id;
    private String nome;
    private String telefone;

    public UserDTO() {}

    public UserDTO(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.telefone = user.getTelefone();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
