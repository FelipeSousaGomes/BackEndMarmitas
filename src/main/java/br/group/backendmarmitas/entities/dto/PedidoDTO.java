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
    private EnderecoDTO endereco;

    List<ItemPedidoDTO> ItensPedido = new ArrayList<>();

  public PedidoDTO() {}


    public PedidoDTO(Pedido pedido) {
      this.id = pedido.getId();
      this.data = pedido.getData();
      this.status = pedido.getStatus();
      this.user = new UserMinDTO(pedido.getUser());
      this.endereco = new EnderecoDTO(pedido.getEndereco());
        for (ItemPedido item: pedido.getItens()){
            ItensPedido.add(new ItemPedidoDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public UserMinDTO getUser() {
        return user;
    }

    public void setUser(UserMinDTO user) {
        this.user = user;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public List<ItemPedidoDTO> getItensPedido() {
        return ItensPedido;
    }

    public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
        ItensPedido = itensPedido;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (ItemPedidoDTO item : ItensPedido) {
            sum += item.getSubTotal();
        }
        return sum;
    }

}
