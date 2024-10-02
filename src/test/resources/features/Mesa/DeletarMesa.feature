# language: pt
Funcionalidade: Excluir Mesa

  Cenário: Excluir uma mesa existente
    Dado que existe uma mesa com ID 1
    Quando uma requisição DELETE é feita para "/api/v1/mesas/1"
    Então a mesa deve ser excluída com sucesso
    E deve retornar um status 200

  Cenário: Falha ao excluir uma mesa inexistente
    Dado que a mesa com ID 999 não existe
    Quando uma requisição DELETE é feita para "/api/v1/mesas/999"
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
