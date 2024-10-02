# language: pt
Funcionalidade: Buscar Mesa Específica

  Cenário: Buscar uma mesa específica por ID
    Dado que existe uma mesa com ID 1
    Quando uma requisição GET é feita para "/api/v1/mesas/1"
    Então deve retornar os detalhes da mesa
    E deve retornar um status 200

  Cenário: Falha ao buscar uma mesa com ID inexistente
    Dado que a mesa com ID 999 não existe
    Quando uma requisição GET é feita para "/api/v1/mesas/999"
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
