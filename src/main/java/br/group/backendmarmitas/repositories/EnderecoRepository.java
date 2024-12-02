package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.Endereco;
import br.group.backendmarmitas.entities.dto.EnderecoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    public List<EnderecoDTO> findByUserId(Long id);
}
