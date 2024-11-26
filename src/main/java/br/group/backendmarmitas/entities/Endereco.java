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
    private String NomeEndereco;
    private Double latitude;
    private Double longitude;
    private String CEP;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private User user;

}
