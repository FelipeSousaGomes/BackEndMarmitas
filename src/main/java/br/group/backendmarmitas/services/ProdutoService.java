package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findById(Long id) {
        Produto prod = repository.findById(id).get();
        return prod;

    }

    public Produto Insert(Produto produto) {
        Produto prod = repository.save(produto);
        return prod;
    }
}
