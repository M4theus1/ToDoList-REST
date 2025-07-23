````markdown
# API REST - Gerenciamento de Usuários e Tarefas com Spring Boot e JWT

Este projeto é um desafio para criação de uma API REST utilizando Spring Boot que oferece funcionalidades de cadastro de usuários, autenticação com JWT, gerenciamento de tarefas, e tratamento de exceções com validação dos dados.

---

## Funcionalidades

- Cadastro de usuários com validação dos dados
- Login com geração de token JWT
- Rotas protegidas que exigem autenticação via token
- CRUD básico para tarefas vinculadas a usuários
- Tratamento global de exceções e validação
- Segurança usando Spring Security e BCrypt para senhas

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Security
- JWT (io.jsonwebtoken)
- JPA / Hibernate
- Banco de dados (H2, MySQL, ou outro configurado)
- Bean Validation (Jakarta Validation)
- Maven

---

## Endpoints Principais

| Método | Endpoint           | Descrição                     | Protegido? |
|--------|--------------------|-------------------------------|------------|
| POST   | `/auth/register`   | Cadastro de usuário            | Não        |
| POST   | `/auth/login`      | Login e recebimento do token   | Não        |
| GET    | `/tasks`           | Listar tarefas do usuário      | Sim        |
| POST   | `/tasks`           | Criar nova tarefa              | Sim        |
| PUT    | `/tasks/{id}`      | Atualizar tarefa               | Sim        |
| DELETE | `/tasks/{id}`      | Deletar tarefa                | Sim        |

---

## Como Rodar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven
- Banco de dados configurado (opcional: H2 para testes)

### Passos

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
````

2. Configure o banco de dados em `application.properties` (opcional, se usar H2, já está pronto).

3. Compile e rode o projeto:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a API em:

   ```
   http://localhost:8080
   ```

---

## Testando a API

### Cadastro de usuário

```http
POST /auth/register
Content-Type: application/json

{
  "name": "João",
  "email": "joao@email.com",
  "password": "123456"
}
```

### Login para obter token JWT

```http
POST /auth/login
Content-Type: application/json

{
  "email": "joao@email.com",
  "password": "123456"
}
```

Resposta:

```json
"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

### Usando token para acessar rotas protegidas

Inclua o token no header da requisição:

```
Authorization: Bearer <seu_token_jwt>
```

Exemplo para listar tarefas:

```http
GET /tasks
Authorization: Bearer <seu_token_jwt>
```

---

## Tratamento de erros

* Validações retornam erros claros com status `400 Bad Request`.
* Recursos não encontrados retornam `404 Not Found`.
* Erros de autenticação retornam `401 Unauthorized`.
* Outros erros internos retornam `500 Internal Server Error`.

---

## Melhorias Futuras

* Implementar refresh tokens
* Documentar API com Swagger/OpenAPI
* Permissões e roles de usuários
* Paginação e filtros para tarefas
* Testes automatizados

---

## Autor

Matheus Silva

---

## Licença

Este projeto está licenciado sob a MIT License.

```

---
```
