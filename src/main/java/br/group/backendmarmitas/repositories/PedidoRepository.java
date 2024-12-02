package br.group.backendmarmitas.repositories;

import br.group.backendmarmitas.entities.Pedido;
import br.group.backendmarmitas.entities.dto.PedidoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    public List<PedidoDTO>findPedidoByUserId(Long id);
}
