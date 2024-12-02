package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    public Carrinho findCarrinhoByUsuarioId(Long id);
    @Query("SELECT c FROM Carrinho c WHERE c.usuario.id = :id AND c.status = 0")
    public Carrinho findCarrinhoByUsuarioStatus(Long id);
}
