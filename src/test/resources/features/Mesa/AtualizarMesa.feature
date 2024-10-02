# language: pt
Funcionalidade: Atualizar Mesa

  Cenário: Atualizar uma mesa existente
    Dado que o usuário fornece novos dados para a mesa com ID 1
    Quando uma requisição PUT é feita para "/api/v1/mesas/1"
    Então a mesa deve ser atualizada com sucesso
    E deve retornar um status 200

  Cenário: Falha ao atualizar uma mesa inexistente
    Dado que a mesa com ID 999 não existe
    Quando uma requisição PUT é feita para "/api/v1/mesas/999" com novos dados
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
