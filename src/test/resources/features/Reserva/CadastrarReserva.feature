# language: pt
Funcionalidade: Criar Reserva

  Cenário: Criar uma nova reserva
    Dado que o usuário fornece os dados de uma reserva
    Quando uma requisição POST é feita para "/api/v1/reservas"
    Então a reserva deve ser criada com sucesso
    E deve retornar um status 201

  Cenário: Falha ao criar uma nova reserva por dados inválidos
    Dado que o usuário envia dados inválidos para criar uma reserva
    Quando uma requisição POST é feita para "/api/v1/reservas"
    Então a reserva não deve ser criada
    E deve retornar um status 400
