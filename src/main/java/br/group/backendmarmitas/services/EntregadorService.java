package br.group.backendmarmitas.services;


import br.group.backendmarmitas.entities.Entregador;
import br.group.backendmarmitas.entities.Pedido;
import br.group.backendmarmitas.entities.dto.EntregadorDTO;
import br.group.backendmarmitas.entities.dto.PedidoDTO;
import br.group.backendmarmitas.repositories.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public EntregadorDTO findById(Long id) {

        Entregador entregador = entregadorRepository.findById(id).get();
        return new EntregadorDTO(entregador);
    }

    public List<EntregadorDTO> findAll() {
        List<Entregador> entregadores = entregadorRepository.findAll();
        return entregadores.stream().map(x -> new EntregadorDTO(x)).toList();
    }

}
