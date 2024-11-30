package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.*;
import br.group.backendmarmitas.entities.dto.ItemPedidoDTO;
import br.group.backendmarmitas.entities.dto.PedidoDTO;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import br.group.backendmarmitas.repositories.*;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository  produtoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntregadorRepository entregadorRepository;


    public PedidoDTO findById(Long id) {

        Pedido pedido = pedidoRepository.findById(id).get();
        return new PedidoDTO(pedido);

    }


    public @Valid PedidoDTO insert(@Valid PedidoDTO dto) {
        // Cria uma nova entidade Pedido
        Pedido pedido = new Pedido();

        // Preenche os campos do pedido com os dados do DTO
        pedido.setData(Instant.now());
        pedido.setStatus(StatusDoPedido.PREPARANDO);

        // Associa o usuário
        User user = userRepository.findById(dto.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        pedido.setUser(user);

        // Associa o entregador, se fornecido
        if (dto.getEntregador() != null) {
            Entregador entregador = entregadorRepository.findById(dto.getEntregador().getId())
                    .orElseThrow(() -> new RuntimeException("Entregador not found"));
            pedido.setEntregador(entregador);
        }

        // Adiciona os itens do pedido
        for (ItemPedidoDTO itemDto : dto.getItensPedido()) {
            ItemPedido itemPedido = new ItemPedido();

            // Carregar o Produto completo usando o ID
            Produto produto = produtoRepository.findById(itemDto.getProdutoid())
                    .orElseThrow(() -> new RuntimeException("Produto not found"));
            itemPedido.setProduto(produto);

            itemPedido.setQuantidade(itemDto.getQuantidade());
            itemPedido.setPreco(itemDto.getPreco());

            // Associa o item ao pedido
            itemPedido.setPedido(pedido);
            pedido.getItens().add(itemPedido);
        }

        // Salva o pedido
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }


    public @Valid PedidoDTO Update(Long id, @Valid PedidoDTO dto) {
            // Busca o pedido existente pelo ID
            Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido not found"));

            // Atualiza os campos do pedido com os dados do DTO
            pedido.setData(dto.getData());
            pedido.setStatus(dto.getStatus());

            // Atualiza o usuário, se o ID for fornecido
            if (dto.getUser() != null && dto.getUser().getId() != null) {
                User user = userRepository.findById(dto.getUser().getId())
                        .orElseThrow(() -> new RuntimeException("User not found"));
                pedido.setUser(user);
            }

            // Atualiza o entregador, se o ID for fornecido
            if (dto.getEntregador() != null && dto.getEntregador().getId() != null) {
                Entregador entregador = entregadorRepository.findById(dto.getEntregador().getId())
                        .orElseThrow(() -> new RuntimeException("Entregador not found"));
                pedido.setEntregador(entregador);
            }

            // Atualiza os itens do pedido
            // Remove os itens antigos (opcional: se você quiser garantir que não haja duplicações)
            pedido.getItens().clear();

            // Adiciona os novos itens
            for (ItemPedidoDTO itemDto : dto.getItensPedido()) {
                ItemPedido itemPedido = new ItemPedido();

                // Carregar o Produto completo usando o ID
                Produto produto = produtoRepository.findById(itemDto.getProdutoid())
                        .orElseThrow(() -> new RuntimeException("Produto not found"));
                itemPedido.setProduto(produto);

                itemPedido.setQuantidade(itemDto.getQuantidade());
                itemPedido.setPreco(itemDto.getPreco());

                // Associa o item ao pedido
                itemPedido.setPedido(pedido);
                pedido.getItens().add(itemPedido);
            }

            // Salva as atualizações no banco de dados
            pedido = pedidoRepository.save(pedido);

            // Retorna o DTO atualizado
            return new PedidoDTO(pedido);
        }


    public List<PedidoDTO> findAll() {
        List<Pedido> result = pedidoRepository.findAll();
        return result.stream().map(x -> new PedidoDTO(x)).toList();
    }

    public void delete(Long id) {
    pedidoRepository.deleteById(id);

    }
}
