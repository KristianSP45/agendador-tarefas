# agendador-tarefas

API REST para gerenciamento de **tarefas agendadas**, permitindo cadastro, atualização, exclusão e controle do status de notificações associadas aos eventos dos usuários.

Este serviço faz parte do ecossistema **Agendador de Tarefas**, sendo responsável pelo armazenamento e gerenciamento dos eventos agendados pelos usuários autenticados.

## Tecnologias

* Java 21
* Spring Boot 3.5.9
* Spring Web
* Spring Data MongoDB
* Spring Security
* JWT (JJWT)
* OpenFeign
* MapStruct
* Lombok
* SonarQube
* Gradle

## Melhorias implementadas

* Persistência utilizando **MongoDB**
* Autenticação baseada em **JWT**
* Conversão DTO ↔ Entity com **MapStruct**
* Atualização parcial com **TarefasUpdateConverter**
* Tratamento global de exceções
* Integração com a **API de Usuários** utilizando **OpenFeign**
* Configuração de **SonarQube** para análise estática
* Workflows de automação com **GitHub Actions**

## Endpoints

Base URL:

```http
/tarefas
```

| Método | Endpoint                           | Descrição                             |
| ------ | ---------------------------------- | ------------------------------------- |
| POST   | `/tarefas`                         | Cadastrar nova tarefa                 |
| GET    | `/tarefas`                         | Listar tarefas do usuário autenticado |
| GET    | `/tarefas/eventos`                 | Buscar tarefas pendentes por período  |
| PUT    | `/tarefas?id={id}`                 | Atualizar dados da tarefa             |
| PATCH  | `/tarefas?id={id}&status={status}` | Alterar status da notificação         |
| DELETE | `/tarefas?id={id}`                 | Remover tarefa pelo ID                |

### Exemplo de cadastro

```json
{
  "nomeTarefa": "Reunião de projeto",
  "descricao": "Reunião semanal da equipe",
  "dataEvento": "20-08-2026 14:00:00"
}
```

## Segurança

A API utiliza **Spring Security + JWT** para autenticação dos usuários.

### Header obrigatório

```http
Authorization: Bearer <token>
```

O e-mail do usuário é extraído automaticamente do token JWT e associado à tarefa cadastrada.

## Integração externa

A aplicação possui integração com a **API de Usuários** através do **OpenFeign** para validação e consulta de dados do usuário autenticado.

## Regras de negócio

* Toda tarefa é vinculada ao **usuário autenticado**
* O status inicial de uma nova tarefa é **PENDENTE**
* A data de criação é gerada automaticamente no momento do cadastro
* Apenas tarefas do usuário autenticado podem ser consultadas
* Atualizações preservam os campos não enviados na requisição
* A busca por período retorna apenas tarefas com status **PENDENTE**

## Tratamento de exceções

* `ResourceNotFoundException` → 404
* `UnauthorizedException` → 401
* `GlobalExceptionHandler` → padronização das respostas de erro

## Testes

No momento, esta API **não possui testes unitários implementados**.

## Automação / CI

O projeto possui **GitHub Actions** configurado para automação de build e integração contínua.

## Como executar

```bash
git clone https://github.com/KristianSP45/agendador-tarefas
cd Agendador-tarefas
./gradlew bootRun
```

A aplicação ficará disponível em:

```
http://localhost:8081
```

## Swagger

Após iniciar a aplicação, acesse:

```
http://localhost:8081/swagger-ui/index.html
```

## Docker

O projeto possui suporte para **Docker**.

### Comandos principais

```bash
docker build -t agendador-tarefas .
docker run -p 8081:8081 agendador-tarefas
```

## Observações

* Projeto desenvolvido durante um **curso prático de Spring Boot e Microsserviços**, acompanhando as aulas e realizando implementações junto à instrutora.
* Utilizado para aprendizado de **MongoDB, JWT, OpenFeign, Docker, SonarQube e comunicação entre microsserviços**.
* Este serviço é responsável pelo **gerenciamento central das tarefas e eventos agendados** do ecossistema da aplicação.

## Autor

**Kristian Pessoa**
