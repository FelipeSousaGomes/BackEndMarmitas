package br.group.backendmarmitas.entities;

import br.group.backendmarmitas.entities.Pedido;
import br.group.backendmarmitas.entities.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String descricao;
    private String cep;
    private String complemento;
    private Integer numero;

    @OneToMany(mappedBy = "endereco")
    @JsonManagedReference  // Evita o loop, serializa a lista de pedidos
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
