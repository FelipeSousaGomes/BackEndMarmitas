package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_entregador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PlacaVeiculo;
    private Disponibilidade disponibilidade;

    @OneToMany(mappedBy = "entregador")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "entregador")
    private List<Rota> rotas;

}
