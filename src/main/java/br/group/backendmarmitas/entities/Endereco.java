package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "user_id") // Usando @ManyToOne caso queira salvar apenas o id
    private User user;
}

