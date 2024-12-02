package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.CarrinhoEnum;

public class CarrinhoDto {
    private Long id;
    private CarrinhoEnum status;
    private UserDTO usuario;


    public CarrinhoDto(Long id, CarrinhoEnum status, UserDTO usuario) {
        this.id = id;
        this.status = status;
        this.usuario = usuario;
    }

    public CarrinhoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarrinhoEnum getStatus() {
        return status;
    }

    public void setStatus(CarrinhoEnum status) {
        this.status = status;
    }

    public UserDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UserDTO usuario) {
        this.usuario = usuario;
    }
}
