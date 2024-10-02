# language: pt
Funcionalidade: Listar Avaliações

  Cenário: Listar todas as avaliações
    Dado que existem avaliações cadastradas
    Quando uma requisição GET é feita para "/api/v1/avaliacoes"
    Então deve retornar uma lista de avaliações
    E deve retornar um status 200

  Cenário: Falha ao listar avaliações quando não há registros
    Dado que não existem avaliações cadastradas
    Quando uma requisição GET é feita para "/api/v1/avaliacoes"
    Então deve retornar uma lista vazia
    E deve retornar um status 404
