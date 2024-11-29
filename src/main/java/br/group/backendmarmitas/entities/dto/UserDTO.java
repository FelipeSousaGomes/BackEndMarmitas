package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDTO {


    private Long id;
    private String nome;
    private String CPF;
    private String email;
    private String telefone;
    private String senha;

    private UserRole role;

    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.CPF = user.getCPF();
        this.email = user.getEmail();
        this.telefone = user.getTelefone();
        this.senha = user.getSenha();
        this.role = user.getRole();
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

