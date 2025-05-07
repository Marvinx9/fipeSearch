package com.example.fipe.principal;

import com.example.fipe.model.DadosMarca;
import com.example.fipe.model.DadosModelo;
import com.example.fipe.model.Marca;
import com.example.fipe.model.Modelo;
import com.example.fipe.service.ConsumoApi;
import com.example.fipe.service.ConverteDados;
import com.example.fipe.service.LimpaString;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Scanner;

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

        String enderecoMarca = ENDERECO + limpaString.removeSpecialCharacters(tipoVeiculo).toLowerCase() + "/marcas";
        var jsonMarcas = consumo.obterDados(enderecoMarca);

        List<DadosMarca> dadosMarcas = conversor.obterDados(jsonMarcas, new TypeReference<>() {});

        List<Marca> marcas = dadosMarcas.stream().map(Marca::new).toList();
        marcas.forEach(System.out::println);

        System.out.println("\nInforme o código da marca para consulta:");
        int codigo = leitura.nextInt();

        String enderecoModelos = enderecoMarca + "/" + codigo + "/modelos";
        var jsonModelos = consumo.obterDados(enderecoModelos);

        System.out.println(jsonModelos);
        List<DadosModelo> dadosmodelos = conversor.obterDados(jsonModelos, new TypeReference<>() {});

        List<Modelo> modelos = dadosmodelos.stream().map(Modelo::new).toList();
        modelos.forEach(System.out::println);
    }
}
