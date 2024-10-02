# language: pt
Funcionalidade: Listar Restaurantes

  Cenário: Listar todos os restaurantes
    Dado que existem restaurantes cadastrados
    Quando uma requisição GET é feita para "/api/v1/restaurantes"
    Então deve retornar uma lista de restaurantes
    E deve retornar um status 200

  Cenário: Falha ao listar restaurantes quando não há registros
    Dado que não existem restaurantes cadastrados
    Quando uma requisição GET é feita para "/api/v1/restaurantes"
    Então deve retornar uma lista vazia
    E deve retornar um status 404
