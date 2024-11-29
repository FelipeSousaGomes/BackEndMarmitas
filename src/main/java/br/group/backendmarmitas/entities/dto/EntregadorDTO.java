package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Disponibilidade;
import br.group.backendmarmitas.entities.Entregador;
import jakarta.persistence.*;

public class EntregadorDTO {

    private Long id;
    private String nome;
    private String placa;


    public EntregadorDTO() {}

    public EntregadorDTO(Entregador entregador) {
        this.id = entregador.getId();
        this.nome = entregador.getNome();
        this.placa = entregador.getPlaca();
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
