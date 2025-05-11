package com.example.fipe.principal;

import com.example.fipe.model.*;
import com.example.fipe.service.ConsumoApi;
import com.example.fipe.service.ConverteDados;
import com.example.fipe.service.LimpaString;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LimpaString limpaString = new LimpaString();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void menu() throws JsonProcessingException {
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
        leitura.nextLine();

        String enderecoModelos = enderecoMarca + "/" + codigo + "/modelos";
        var jsonModelos = consumo.obterDados(enderecoModelos);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonModelos);
        JsonNode modelosnode = rootNode.get("modelos");

        String modelosjsonstring = modelosnode.toString();
        List<DadosModelo> dadosmodelos = conversor.obterDados(modelosjsonstring, new TypeReference<>(){});

        List<Modelo> modelos = dadosmodelos.stream().map(Modelo::new).toList();
        modelos.forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do veículo para consulta:");
        var filtroPorModelo = leitura.nextLine();

        Modelo veiculo = null;
        for (Modelo modelo : modelos) {
            if(modelo.getDescricao().toLowerCase().trim().contains(filtroPorModelo.trim().toLowerCase())) {
                veiculo = modelo;
            }
        }

        if (veiculo == null) {
            throw new RuntimeException("veiculo não encontrado nessa sessão");
        }

        String  anosVeiculo = enderecoModelos + "/" + veiculo.getCod() + "/anos";

        var jsonVeiculos = consumo.obterDados(anosVeiculo);
        List<DadosVeiculo> dadosVeiculos = conversor.obterDados(jsonVeiculos, new TypeReference<>() {});

        List<Veiculo> veiculos = dadosVeiculos.stream().map(Veiculo::new).toList();
        veiculos.forEach(System.out::println);

        System.out.println("Digite o código do ano referente ao seu veículo");
        var ano = leitura.nextLine();

        String buscaPorAno = anosVeiculo + "/" + ano;
        var jsonFipeData = consumo.obterDados(buscaPorAno);

        DadosFipeData dadosFipe = conversor.converteFipe(jsonFipeData, new TypeReference<>() {});

        System.out.println(dadosFipe.toString());
    }
}
