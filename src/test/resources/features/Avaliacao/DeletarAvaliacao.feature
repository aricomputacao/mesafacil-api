# language: pt
Funcionalidade: Excluir Avaliação

  Cenário: Excluir uma avaliação existente
    Dado que existe uma avaliação com ID 1
    Quando uma requisição DELETE é feita para "/api/v1/avaliacoes/1"
    Então a avaliação deve ser excluída com sucesso
    E deve retornar um status 200

  Cenário: Falha ao excluir avaliação inexistente
    Dado que a avaliação com ID 999 não existe
    Quando uma requisição DELETE é feita para "/api/v1/avaliacoes/999"
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
