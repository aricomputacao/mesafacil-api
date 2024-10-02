# language: pt
Funcionalidade: Atualizar Avaliação

  Cenário: Atualizar uma avaliação existente
    Dado que o usuário fornece novos dados para a avaliação com ID 1
    Quando uma requisição PUT é feita para "/api/v1/avaliacoes/1"
    Então a avaliação deve ser atualizada com sucesso
    E deve retornar um status 200

  Cenário: Falha ao atualizar avaliação inexistente
    Dado que a avaliação com ID 999 não existe
    Quando uma requisição PUT é feita para "/api/v1/avaliacoes/999" com novos dados
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
