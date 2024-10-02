# language: pt
Funcionalidade: Atualizar Reserva

  Cenário: Confirma uma reserva
    Dado que o usuário fornece novos dados para a reserva com ID 1
    Quando uma requisição PUT é feita para "/api/v1/reservas/1"
    Então a reserva deve ser confirmada com sucesso
    E o status da mesa deve ser atualizado para indisponível
    E deve retornar um status 200

  Cenário: Falha ao Confirmar reserva inexistente
    Dado que a reserva com ID 999 não existe
    Quando uma requisição PUT é feita para "/api/v1/reservas/999" com novos dados
    Então deve retornar uma mensagem de erro
    E deve retornar um status 404
