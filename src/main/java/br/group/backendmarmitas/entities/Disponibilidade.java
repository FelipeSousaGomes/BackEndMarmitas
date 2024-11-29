package br.group.backendmarmitas.entities;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

public enum Disponibilidade {
    DISPONIVEL("Disponível"),
    EM_ROTA("Em Rota"),
    INDISPONIVEL("Indisponível");

    private String nome;

    Disponibilidade(String nome) {
        this.nome = nome;
    }

    public static Disponibilidade fromNome(String nome) {
        return Arrays.stream(Disponibilidade.values())
                .filter(disponibilidade -> disponibilidade.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nome de disponibilidade inválido: " + nome));
    }

    public String getNome() {
        return nome;
    }

    @Converter(autoApply = true)
    public static class DisponibilidadeConverter implements AttributeConverter<Disponibilidade, String> {

        @Override
        public String convertToDatabaseColumn(Disponibilidade disponibilidade) {
            return disponibilidade == null ? null : disponibilidade.getNome();
        }

        @Override
        public Disponibilidade convertToEntityAttribute(String nome) {
            return nome == null ? null : Disponibilidade.fromNome(nome);
        }
    }
}



