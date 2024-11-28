package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import br.group.backendmarmitas.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoDTO findById(Long id) {
        Produto prod = repository.findById(id).get();
        return new ProdutoDTO(prod);

    }

    public ProdutoDTO Insert(ProdutoDTO dto) {
        Produto prod = new Produto();
        copyDtoToEntity(dto,prod);
        prod = repository.save(prod);
        return new ProdutoDTO(prod);
    }





    private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
    }

    public ProdutoDTO Update(Long id, ProdutoDTO dto) {
            Produto entity = repository.getReferenceById(id);
             copyDtoToEntity(dto,entity);
             entity = repository.save(entity);
             return new ProdutoDTO(entity);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> result = repository.findAll();
        return result.stream().map(x -> new ProdutoDTO(x)).toList();
    }
}
