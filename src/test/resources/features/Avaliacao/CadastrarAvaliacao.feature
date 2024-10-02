# language: pt
Funcionalidade: Criar Avaliação

  Cenário: Criar uma nova avaliação
    Dado que o usuário envia os dados de uma avaliação
    Quando uma requisição POST é feita para "/api/v1/avaliacoes"
    Então a avaliação deve ser criada com sucesso
    E deve retornar um status 201

