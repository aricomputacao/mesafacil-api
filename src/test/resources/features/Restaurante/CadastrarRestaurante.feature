# language: pt
Funcionalidade: Cadastrar Restaurante

  Cenário: Cadastrar um novo restaurante
    Dado que o usuário fornece os dados de um novo restaurante
    Quando uma requisição POST é feita para "/api/v1/restaurantes"
    Então o restaurante deve ser cadastrado com sucesso
    E deve retornar um status 201

  Cenário: Falha ao cadastrar um novo restaurante por dados inválidos
    Dado que o usuário envia dados inválidos para cadastrar um restaurante
    Quando uma requisição POST é feita para "/api/v1/restaurantes"
    Então o restaurante não deve ser cadastrado
    E deve retornar um status 400
