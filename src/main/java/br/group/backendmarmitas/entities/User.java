package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CPF;
    @Column(unique = true)
    private String email;
    private String telefone;
    private String senha;

    @OneToMany(mappedBy = "user")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToOne
    @MapsId
    private Endereco endereco;

}