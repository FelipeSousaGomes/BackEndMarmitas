package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
