# Desafio 04

Este projeto é uma implementação do desafio 04, desenvolvido em Java Spring

## 🚀 Tecnologias Utilizadas

- **[Java 21](https://www.oracle.com/br/java/technologies/downloads/)**
- **[Spring Boot 3.4.4](https://spring.io/projects/spring-boot)**
- **[Spring Web](https://docs.spring.io/spring-boot/reference/web/index.html)**
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**
- **[PostgreSQL](https://www.postgresql.org/)** (Banco de dados)
- **[Maven](maven.apache.org)** (gerenciamento de dependências e build)
- **[Swagger](https://springdoc.org/)** (Documentação da API)
- **[JUnit 5](https://junit.org/junit5/)** (Testes unitários)
- **[Mockito](https://site.mockito.org/)** (Testes unitários)

## 🛠 Configuração e Execução

### Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [JDK 21](https://www.oracle.com/br/java/technologies/downloads/#java21)
- [Maven](https://maven.apache.org/)

### Instalação e Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/onurbeht/teste-intuitive-care
   cd <Diretorio do repositorio>/desafio04
   ```

2. A base de dados usada, é a mesma do desafio03, para configurar:

   - Navegue até o arquivo: <diretorio-do-projeto>/src/main/resources/application.yml
   - E adicione as seguintes configurações, que foram usadas no Desafio03:
     ```yml
     datasource:
       url: jdbc:postgresql://localhost:5432/<Nome-do-database-usado-no-desafio03>
       username: <Username-do-database-usado-no-desafio03>
       password: <Password-do-database-usado-no-desafio03>
     ```

3. Instale as dependências, compile e execute a aplicação:

   ```bash
   mvn install
   ```

   ```bash
   mvn spring-boot:run
   ```

4. Para testar, acesse a aplicação, você pode usar um client API(Ex: Postman, Insomnia) na URL padrão http://localhost:8080/api **ou pelo Swagger - http://localhost:8080/api/swagger-ui/index.html** :

   - Listagem de operadoras de saude.
     Envie uma resuisição GET para a URL: http://localhost:8080/api/operadoras

   O retorno da requisição seria uma paginação, com os seguintes dados:

   ```json
    {
    "content": [{
        "registro_ans": Integer,
        "cnpj": String,
        "razao_social": String,
        "nome_fantasia": String,
        "modalidade": String,
        "logradouro": String,
        "numero": String,
        "complemento": String,
        "bairro": String,
        "cidade": String,
        "uf": String,
        "cep": String,
        "ddd": String,
        "telefone": String,
        "fax": String,
        "endereco_eletronico": String,
        "representante": String,
        "cargo_representante": String,
        "regiao_de_comercializacao": integer,
        "data": String
        }],
    "totalPages": interger,
    "totalElements": integer,
    "size": integer,
    "number": integer,
    "first": boolean,
    "last": boolean
    }
   ```

   Teste a requisição com outros valores.
   Ex:

   - http://localhost:8080/api/operadoras?sort=data,ASC
   - http://localhost:8080/api/operadoras?sort=cnpj,DESC&page=1&size=3
   - http://localhost:8080/api/operadoras?page=1&size=2&sort=data,cnpj,ASC

## Collection Postman

- https://bruno-8143381.postman.co/workspace/Bruno's-Workspace~383993b9-8a2b-417d-8494-21037854dfe1/collection/43692014-d79d8859-9575-47db-a1e2-1a9a56d71d3e?action=share&creator=43692014
