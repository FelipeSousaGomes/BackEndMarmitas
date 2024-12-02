package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
