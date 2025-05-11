## FipeApplication

Este projeto é uma aplicação Java que consome a API pública da Tabela FIPE.  
A Tabela Fipe expressa preços médios de veículos no mercado nacional, servindo apenas como um parâmetro para negociações ou avaliações.  
Os preços efetivamente praticados variam em função da região, conservação, cor, acessórios ou qualquer outro fator que possa influenciar as condições de oferta e procura por um veículo específico.

### Funcionalidades

- Consulta de marcas de veículos (carros, motos e caminhões)
- Listagem de modelos por marca
- Filtro de modelos por nome
- Consulta de versões por ano
- Exibição de detalhes com preço médio FIPE

### Tecnologias utilizadas

- Java 17+
- Jackson (para desserialização JSON)
- API pública da Tabela FIPE: https://parallelum.com.br/fipe/api/v1/
