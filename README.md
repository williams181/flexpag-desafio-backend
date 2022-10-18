<p align="center">
 <img src="https://github.com/jsantos-examples/flexpag-desafio-backend/blob/main/contents/flexpag.png" width="600" alt="Banner Flexpag">
</p>

# 🚀 Desafio backend

Bem-vindo(a). Este é o desafio Back end!

O objetivo deste desafio é avaliar suas habilidades em programação.
Quando concluir o desafio, basta responder o e-mail onde recebeu o link do repositório.
Em seguida, enviaremos o feedback e as instruções dos próximos passos!

Caso tenha alguma dúvida, nós estamos disponíveis para tirá-las.
Bom desafio!

> ⚠️ **É importante que o seu repo esteja público, caso contrário não iremos conseguir avaliar sua resposta**

---

- [🧠 Contexto](#-contexto)
  - [🚰 Fluxo esperado](#-fluxo-esperado)
- [✔️ Critérios de Avaliação](#️-critérios-de-avaliação)
- [:rocket: Instruções](#rocket-instruções)
  - [:notebook: To-do list](#notebook-to-do-list)

# 🧠 Contexto

A Flexpag é uma empresa de tecnologia especializada em soluções digitais de pagamento. Sabendo disso, montamos um desafio que consiste em implementar um serviço de pagamento agendando.

### 🚰 Fluxo esperado

- Quando um agendamento é enviado deve ser registrado como `pending` e retornado o id;
- O usuário deve conseguir consultar o status do agendamento `pending`|`paid`;
- :warning: **Se o pagamento ainda não foi realizado o usuário pode**;
  - Excluir o agendamento;
  - Atualizar a data:hora do agendamento;
  
## ✔️ Critérios de Avaliação

Além dos requisitos levantados acima, iremos olhar para os seguintes critérios durante a correção do desafio:

- Eficiência e simplicidade;

## :rocket: Instruções

Chegou a hora de colocar a mão na massa!

### Aplicação

A aplicação já está com o pre setup default. 

**dependências:**
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-devtools
- h2
- lombok

| componente | porta |
| --------- | ----------- |
| Aplicação  | `8080` |

aplication.yaml foi configurado para apontar para o banco local h2
```
spring:
  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:payment-scheduler
    username: admin
    password: admin
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        show_sql: true
```

### :notebook: To-do list
- [ ] Fazer o fork do projeto
- [ ] Implementar solução
- [ ] Enviar link do projeto

:information_source: _Sinta-se livre para incluir quaisquer observações que achar necessário_

Recomendação: após executar o projeto, utilizar o swagger para visualização dos end points e testes dos metódos atráves do link: http://localhost:8080/swagger-ui/index.html#/

1º criar usuário.

POST

http://localhost:8080/usuario/salvar

{
  "email": "exemplo@hotmail.com",
  "senha": "123456789"
}

2º autenticação

POST

http://localhost:8080/auth/login

{
  "email": "exemplo@hotmail.com",
  "senha": "123456789"
}

3º copiar Bearer toker e passar no authorization

4º criar uma pessoa 

POST

http://localhost:8080/pessoa/salvar

{
  "cnpj": "000000-00000XXXXX",
  "cpf": "000.000.000-00",
  "data_nascimento": "2022-10-17",
  "nome": "william",
  "telefone": "99 9999 9999",
  "usuario_id": 1
}

5º criar um agendamento

POST

http://localhost:8080/agendamento/salvar

{
  "dataAgendamento": "2022-10-17T19:19:30.440Z",
  "statusPagamento": false,
  "status_agendamento": "PENDENTE",
  "usuario_id": 1,
  "valorPagamento": 10
}

6º textar os metodos:

PUT

http://localhost:8080/agendamento/editar/1

DELETE

http://localhost:8080/agendamento/remover/1

---

_O desafio acima foi cuidadosamente construído para propósitos de avaliação apenas._
