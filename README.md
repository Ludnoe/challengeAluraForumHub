# FórumHub

![thumbForumHub](https://github.com/user-attachments/assets/b16df508-5890-41cc-a6f7-9961e88a3bf5)

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)
![MySQL](https://img.shields.io/badge/MySQL-8-orange)
![Maven](https://img.shields.io/badge/Maven-4-yellow)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## Índice

- [Descrição do Projeto](#descrição-do-projeto)
- [Status do Projeto](#status-do-projeto)
- [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
- [Como Utilizar](#como-utilizar)
- [Acesso ao Projeto](#acesso-ao-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Licença](#licença)

## Descrição do Projeto

O FórumHub é uma API REST para gerenciamento de tópicos em um fórum, permitindo a criação, leitura, atualização e exclusão de tópicos. É uma ferramenta ideal para escolas online, onde alunos e professores podem interagir, tirar dúvidas e compartilhar conhecimentos sobre cursos e projetos.

## Status do Projeto

![Status do Projeto](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

## Funcionalidades e Demonstração da Aplicação

### Funcionalidades:

- **Criar um novo tópico**
- **Mostrar todos os tópicos**
- **Mostrar um tópico específico**
- **Atualizar um tópico**
- **Excluir um tópico**

### Demonstração da Aplicação:

1. **Listar Tópicos (GET)**
    - URL: `http://localhost:8080/topicos`
    - Método: GET
    - Retorna uma lista de todos os tópicos cadastrados.

2. **Criar Tópico (POST)**
    - URL: `http://localhost:8080/topicos`
    - Método: POST
    - Headers: `Content-Type: application/json`
    - Body (JSON):
      ```json
      {
        "titulo": "Exemplo de Título",
        "mensagem": "Exemplo de Mensagem",
        "status": "ABERTO",
        "autor_id": 1,
        "curso_id": 1
      }
      ```
    - Cria um novo tópico no fórum.

## Como Utilizar

Para utilizar a API FórumHub, siga os passos abaixo:

### Requisitos

- Java JDK 17
- Maven 4
- MySQL 8
- IntelliJ IDEA (ou outra IDE de sua escolha)

### Passos para rodar a aplicação

1. **Clone o repositório:**
   ```bash
   git clone hhttps://github.com/Ludnoe/challengeAluraForumHub.git
   cd forumhub
   ```
2. **Configure o banco de dados:**

   No arquivo application.properties, configure a URL do banco de dados, usuário e senha:

```
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

3. **Rode as migrations do Flyway:**

```
mvn flyway:migrate
```

4. **Compile e execute a aplicação:**

```
mvn spring-boot:run
```

5. **Testes com Insomnia ou Postman:**

   Utilize os endpoints da API para interagir com a aplicação.

## Acesso ao Projeto
Você pode acessar o projeto [aqui](https://github.com/Ludnoe/challengeAluraForumHub).

## Tecnologias Utilizadas
   - Java 17
   - Spring Boot 3
   - MySQL 8
   - Maven 4
   - Flyway Migration
   - Spring Security
   - Lombok
   - Spring Data JPA
   - Spring Web
   - Spring Boot DevTools
   - Validation

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Observação
   Este é um projeto em desenvolvimento, algumas funcionalidades ainda vão ser implementadas, assim como melhorias nas que já estão.