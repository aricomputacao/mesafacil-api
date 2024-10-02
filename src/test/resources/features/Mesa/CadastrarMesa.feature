# language: pt
Funcionalidade: Cadastrar Mesa

  Cenário: Criar uma nova mesa associada a um restaurante
    Dado que o usuário fornece os dados de uma nova mesa
    Quando uma requisição POST é feita para "/api/v1/restaurantes/1/mesas"
    Então a mesa deve ser criada com sucesso
    E deve retornar um status 201

  Cenário: Falha ao criar uma mesa para um restaurante inexistente
    Dado que o restaurante com ID 999 não existe
    Quando uma requisição POST é feita para "/api/v1/restaurantes/999/mesas" com os dados da mesa
    Então a mesa não deve ser criada
    E deve retornar um status 404
