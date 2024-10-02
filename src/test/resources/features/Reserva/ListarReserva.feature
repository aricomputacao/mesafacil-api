# language: pt
Funcionalidade: Listar Reservas

  Cenário: Listar todas as reservas
    Dado que existem reservas cadastradas
    Quando uma requisição GET é feita para "/api/v1/reservas"
    Então deve retornar uma lista de reservas
    E deve retornar um status 200

  Cenário: Falha ao listar reservas quando não há registros
    Dado que não existem reservas cadastradas
    Quando uma requisição GET é feita para "/api/v1/reservas"
    Então deve retornar uma lista vazia
    E deve retornar um status 404
