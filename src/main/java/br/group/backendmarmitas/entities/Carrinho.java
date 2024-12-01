package br.group.backendmarmitas.entities;

import br.group.backendmarmitas.entities.CarrinhoEnum;
import br.group.backendmarmitas.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_carrinho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @Column(name = "status")
    private CarrinhoEnum status;

}