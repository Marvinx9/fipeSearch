package com.example.fipe.principal;

import com.example.fipe.model.DadosMarca;
import com.example.fipe.model.Marca;
import com.example.fipe.service.ConsumoApi;
import com.example.fipe.service.ConverteDados;
import com.example.fipe.service.LimpaString;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LimpaString limpaString = new LimpaString();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void menu() {
        System.out.println("**** OPÇÕES ****");
        System.out.println("\nCarros\n\nMotos\n\nCaminhões\n\nDigite uma das opções para consultar valores:");
        var tipoVeiculo = leitura.nextLine();

        var json = consumo.obterDados(ENDERECO + limpaString.removeSpecialCharacters(tipoVeiculo).toLowerCase() + "/marcas");
        List<DadosMarca> dados = conversor.obterDados(json, new TypeReference<>() {});

        List<Marca> marcas = dados.stream().map(Marca::new).toList();

        marcas.forEach(System.out::println);
    }
}
