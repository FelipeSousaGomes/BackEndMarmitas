package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.UserRole;

public record RegisterDTO(String email, String senha, String CPF , String telefone, UserRole role, String nome) {
}
