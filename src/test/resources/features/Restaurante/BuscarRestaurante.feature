# language: pt
Funcionalidade: Buscar Restaurante Específico

  Cenário: Buscar um restaurante pelo tipo de culinaria
    Dado que existe um restaurante com a culinaria Brasileira
    Quando uma requisição GET é feita para "/api/v1/restaurantes/tipoDeCulinaria=Brasileira"
    Então deve retornar os detalhes do restaurante
    E deve retornar um status 200

  Cenário: Falha ao buscar um restaurante com tipo inexistente
    Dado que o restaurante com ID 999 não existe
    Quando uma requisição GET é feita para "/api/v1/restaurantes/tipoDeCulinaria=Abc123"
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
