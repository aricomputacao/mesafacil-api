# language: pt
Funcionalidade: Buscar Avaliação Específica

  Cenário: Buscar uma avaliação específica por ID
    Dado que existe uma avaliação com ID 1
    Quando uma requisição GET é feita para "/api/v1/avaliacoes/1"
    Então deve retornar os detalhes da avaliação
    E deve retornar um status 200

  Cenário: Falha ao buscar uma avaliação com ID inexistente
    Dado que a avaliação com ID 999 não existe
    Quando uma requisição GET é feita para "/api/v1/avaliacoes/999"
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
