package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private Instant data;
    private StatusDoPedido status;
    private UserMinDTO user;
    private EntregadorDTO entregador;

    List<ItemPedidoDTO> ItensPedido = new ArrayList<>();

  public PedidoDTO() {}


    public PedidoDTO(Pedido pedido) {
      this.id = pedido.getId();
      this.data = pedido.getData();
      this.status = pedido.getStatus();
      this.user = new UserMinDTO(pedido.getUser());
      this.entregador = new EntregadorDTO(pedido.getEntregador());
        for (ItemPedido item: pedido.getItens()){
            ItensPedido.add(new ItemPedidoDTO(item));
        }
    }


    public Double getTotal(){
        double sum = 0.0;
        for (ItemPedidoDTO item : ItensPedido) {
            sum += item.getSubTotal();
        }
        return sum;
    }

}
