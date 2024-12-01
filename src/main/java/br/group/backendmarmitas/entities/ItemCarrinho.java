package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="tb_item_carrinho")
public class ItemCarrinho {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="quantidade")
        private int quantidade;

        @ManyToOne
        @JoinColumn(name = "id_carrinho", nullable = false)
        private Carrinho carrinho;

        @ManyToOne
        @JoinColumn(name="id_produto", nullable = false)
        private Produto produto;

        @Column(name="ativo")
        private boolean ativo;

}
