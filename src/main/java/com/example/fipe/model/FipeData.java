package com.example.fipe.model;

public class FipeData {
    private String valor;
    private String marca;
    private String modelo;
    private Integer ano;
    private String combustivel;
    private String mesReferencia;

    public FipeData(DadosFipeData dadosFipeData) {
        this.valor = dadosFipeData.valor();
        this.marca = dadosFipeData.marca();
        this.modelo = dadosFipeData.modelo();
        this.ano = dadosFipeData.ano();
        this.combustivel = dadosFipeData.combustivel();
        this.mesReferencia = dadosFipeData.mesReferencia();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    @Override
    public String toString() {
        return "FipeData{" +
                "valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", combustivel='" + combustivel + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                '}';
    }
}
