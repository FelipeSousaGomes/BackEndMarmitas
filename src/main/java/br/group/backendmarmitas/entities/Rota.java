package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_rota")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NomeEndereco;
    private Double latitude;
    private Double longitude;
    private Integer numeroSequencial;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador;
}
