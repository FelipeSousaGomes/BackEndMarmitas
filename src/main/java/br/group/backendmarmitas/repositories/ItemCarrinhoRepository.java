package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

    public List<ItemCarrinho> findItemCarrinhoByCarrinhoId(Long carrinhoId);
}
