package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Entregador;
import br.group.backendmarmitas.entities.StatusDoPedido;
import br.group.backendmarmitas.entities.User;
import jakarta.persistence.*;

import java.time.Instant;

public class PedidoDTO {
    private Long id;
    private Instant data;
    private StatusDoPedido status;
}
