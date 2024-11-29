package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.Entregador;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
}
