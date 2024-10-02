# language: pt
Funcionalidade: Listar Mesas

  Cenário: Listar todas as mesas de um restaurante
    Dado que existem mesas cadastradas para o restaurante com ID 1
    Quando uma requisição GET é feita para "/api/v1/restaurantes/1/mesas"
    Então deve retornar uma lista de mesas
    E deve retornar um status 200

  Cenário: Falha ao listar mesas de um restaurante inexistente
    Dado que o restaurante com ID 999 não existe
    Quando uma requisição GET é feita para "/api/v1/restaurantes/999/mesas"
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
