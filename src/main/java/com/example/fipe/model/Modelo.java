package com.example.fipe.model;

public class Modelo {
    private Integer cod;
    private String descricao;

    public Modelo(DadosModelo dadosModelo) {
        this.cod = dadosModelo.cod();
        this.descricao = dadosModelo.descricao();
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cód: " + cod + " Descrição: " + descricao;
    }
}
