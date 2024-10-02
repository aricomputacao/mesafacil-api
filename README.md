# 🍽️ Sistema de Reserva e Avaliação de Restaurantes

Bem-vindo ao **Sistema de Reserva e Avaliação de Restaurantes**, uma aplicação em Java com Spring Boot que permite aos usuários buscar, reservar mesas e avaliar restaurantes. O sistema também facilita o gerenciamento de restaurantes e suas mesas, garantindo uma experiência completa para restaurantes e usuários.

## 🧪 Como Testar a Aplicação

Para testar a aplicação, siga os passos abaixo:

1. Clone o repositório para sua máquina local:
    ```bash
    git clone https://github.com/aricomputacao/mesafacil-api.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd mesafacil-api
    ```

3. Certifique-se de ter o Docker instalado. Se não tiver, [instale o Docker](https://docs.docker.com/get-docker/).

4. Suba os containers do Docker utilizando o docker-compose:
    ```bash
    docker-compose -f docker-compose.yml up -d
    ```

5. A aplicação estará disponível e pronta para uso. Verifique a documentação específica para acessar os serviços e endpoints.

## 🛠 Deploys externos

- **Amazon**: [Swagger Publicado na AWS](http://load-balancer-mesafacil-180937660.us-east-1.elb.amazonaws.com/swagger-ui/index.html#/)

## 🚀 Funcionalidades

- **Cadastro de Restaurantes**: Registre novos restaurantes e suas mesas.
- **Gerenciamento de Mesas**: Acompanhe a disponibilidade em tempo real.
- **Reservas**: Permite que usuários façam reservas de mesas em restaurantes.
- **Avaliações**: Usuários podem avaliar restaurantes com notas e comentários.
- **Busca**: Filtros avançados para localizar restaurantes por nome, localização e tipo de cozinha.

## 🛠️ Modelagem do Sistema

### Entidades principais:
- **Restaurante**: Informações sobre o restaurante (nome, localização, tipo de cozinha).
- **Mesa**: Gerenciamento da disponibilidade de mesas.
- **Reserva**: Controle de reservas, incluindo status (PENDENTE, CONFIRMADA, CANCELADA).
- **Avaliação**: Sistema de avaliações com notas de 1 a 5 e comentários.

### API REST:
- **Restaurantes**: Cadastro, consulta e atualização de restaurantes.
- **Mesas**: Gerenciamento de mesas de um restaurante.
- **Reservas**: Criação e gestão de reservas.
- **Avaliações**: Sistema de avaliação de restaurantes.

## 🔍 Exemplo de Uso

1. Cadastre um restaurante e suas mesas.
2. Permita que os usuários busquem restaurantes disponíveis.
3. Gerencie as reservas e a disponibilidade de mesas.
4. Receba feedback dos clientes por meio de avaliações.

## ✅ Testes

### 🧪 Testes Unitários
Garantimos a qualidade e confiabilidade do sistema com **testes unitários** para todas as funcionalidades principais. Cada serviço e regra de negócio é coberto por testes, garantindo que o sistema funcione conforme esperado em diferentes cenários.

### 💡 BDD (Behavior-Driven Development)
Implementamos o BDD para garantir que o comportamento do sistema esteja alinhado com as expectativas dos usuários e stakeholders. Isso torna a colaboração e a validação mais simples e eficaz.

### 🏎️ Testes de Performance
Otimizar o desempenho é crucial em um sistema de reservas em tempo real. Usamos ferramentas de teste de carga e stress para assegurar que o sistema funcione perfeitamente mesmo em horários de pico.

## 🔧 Tecnologias Utilizadas

- **Java** & **Spring Boot**
- **Banco de Dados Relacional**
- **Hibernate/JPA** para persistência de dados
- **Testes**: JUnit, Mockito, Gatling
- **Swagger** para documentação da API
- **JUnit Performance** para testes de desempenho

## 👥 Contribuintes

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
   <td align="center"><a href="https://github.com/aricomputacao" target="blank"><img src="https://avatars.githubusercontent.com/aricomputacao" alt="aricomputacao" width="50" /></a><br>@aricomputacao</td>
   <td align="center"><a href="https://github.com/edipojoseoliveira" target="blank"><img src="https://avatars.githubusercontent.com/edipojoseoliveira" alt="edipojoseoliveira" width="50" /></a><br>@edipojoseoliveira</td>
   <td align="center"><a href="https://github.com/Gabrielzc88" target="blank"><img src="https://avatars.githubusercontent.com/Gabrielzc88" alt="Gabrielzc88" width="50" /></a><br>@Gabrielzc88</td>
   <td align="center"><a href="https://github.com/nicolasrds" target="blank"><img src="https://avatars.githubusercontent.com/nicolasrds" alt="nicolasrds" width="50" /></a><br>@nicolasrds</td>
   <td align="center"><a href="https://github.com/yurialves23" target="blank"><img src="https://avatars.githubusercontent.com/yurialves23" alt="yurialves23" width="50" /></a><br>@yurialves23</td>
  </tr>
</table>