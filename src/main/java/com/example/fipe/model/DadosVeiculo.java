package com.example.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(
        @JsonAlias("codigo") String cod,
        @JsonAlias("nome") String descricao) {
}
