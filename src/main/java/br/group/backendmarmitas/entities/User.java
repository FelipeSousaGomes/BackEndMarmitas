package br.group.backendmarmitas.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CPF;
    @Column(unique = true)
    private String email;
    private String telefone;
    private String senha;

    private UserRole role;

    public User(Long id, String nome, String CPF, String email, String telefone, String senha, UserRole role) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.role = role;
    }

    public User(String email , String senha, UserRole role, String telefone , String CPF, String nome){
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.telefone = telefone;
        this.CPF = CPF;
        this.nome = nome;
    }


    @OneToMany(mappedBy = "user")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.admin)  return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
