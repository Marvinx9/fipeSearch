package com.example.fipe.model;

public class Marca {
    private String cod;
    private String descricao;

    public Marca(DadosMarca dadosMarca) {
        this.cod = dadosMarca.cod();
        this.descricao = dadosMarca.descricao();
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
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
