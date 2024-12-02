package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Entity
@Table(name = "tb_entregador")
@Getter
@Setter

@NoArgsConstructor

public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String placa;
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;
    private Integer capacidade ;



    @OneToMany(mappedBy = "entregador")
    private List<Rota> rotas;

    public Entregador(Long id, String nome, String placa, Disponibilidade disponibilidade, Integer capacidade) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.disponibilidade = disponibilidade;
        this.capacidade = capacidade;
    }
}
