Aqui está o README explicando as dependências usadas no seu projeto:

---

# AG Project

Este é um projeto de exemplo usando Spring Boot. Abaixo estão as dependências Maven utilizadas e suas respectivas finalidades.

## Dependências

### 1. **Spring Boot Starter Parent**
- **GroupId:** `org.springframework.boot`
- **ArtifactId:** `spring-boot-starter-parent`
- **Version:** `3.3.1`
- **Descrição:** Este é o projeto pai que fornece uma configuração básica e um conjunto padrão de dependências para aplicações Spring Boot. Ele simplifica o gerenciamento de versões das dependências e configurações de plugins.

### 2. **JUnit 5 (Jupiter)**
- **GroupId:** `org.junit.jupiter`
- **ArtifactId:** `junit-jupiter`
- **Version:** `5.7.0`
- **Scope:** `test`
- **Descrição:** JUnit 5 é o framework de testes unitários utilizado no projeto. Ele permite escrever e executar testes para validar o comportamento da aplicação.

### 3. **Spring Boot Starter Data JPA**
- **GroupId:** `org.springframework.boot`
- **ArtifactId:** `spring-boot-starter-data-jpa`
- **Descrição:** Fornece uma integração fácil com o Spring Data JPA, facilitando o uso do JPA (Java Persistence API) para persistência de dados.

### 4. **Spring Boot Starter Web**
- **GroupId:** `org.springframework.boot`
- **ArtifactId:** `spring-boot-starter-web`
- **Descrição:** Inclui as bibliotecas necessárias para criar uma aplicação web usando Spring MVC, que facilita a construção de APIs RESTful.

### 5. **Flyway Core**
- **GroupId:** `org.flywaydb`
- **ArtifactId:** `flyway-core`
- **Descrição:** Flyway é uma ferramenta de migração de banco de dados que permite versionar e gerenciar mudanças no esquema do banco de dados.

### 6. **Flyway Database PostgreSQL**
- **GroupId:** `org.flywaydb`
- **ArtifactId:** `flyway-database-postgresql`
- **Descrição:** Suporte específico do Flyway para o banco de dados PostgreSQL, permitindo a execução de migrações no PostgreSQL.

### 7. **Spring Boot DevTools**
- **GroupId:** `org.springframework.boot`
- **ArtifactId:** `spring-boot-starter-devtools`
- **Scope:** `runtime`
- **Optional:** `true`
- **Descrição:** Ferramenta de desenvolvimento que facilita o processo de desenvolvimento, fornecendo funcionalidades como reinicialização automática da aplicação e cache desabilitado.

### 8. **PostgreSQL JDBC Driver**
- **GroupId:** `org.postgresql`
- **ArtifactId:** `postgresql`
- **Scope:** `runtime`
- **Descrição:** O driver JDBC para PostgreSQL, necessário para a conexão com o banco de dados PostgreSQL.

### 9. **Lombok**
- **GroupId:** `org.projectlombok`
- **ArtifactId:** `lombok`
- **Optional:** `true`
- **Descrição:** Lombok é uma biblioteca que reduz a quantidade de código boilerplate no Java, gerando automaticamente métodos getter, setter, construtores e outros.

### 10. **Spring Boot Starter Test**
- **GroupId:** `org.springframework.boot`
- **ArtifactId:** `spring-boot-starter-test`
- **Scope:** `test`
- **Descrição:** Pacote que inclui diversas bibliotecas para facilitar a criação e execução de testes, como JUnit, Hamcrest, e Mockito.

### 11. **H2 Database**
- **GroupId:** `com.h2database`
- **ArtifactId:** `h2`
- **Scope:** `test`
- **Descrição:** H2 é um banco de dados em memória utilizado para testes. Ele permite que a aplicação seja testada sem a necessidade de configurar um banco de dados real.

### 12. **JetBrains Annotations**
- **GroupId:** `org.jetbrains`
- **ArtifactId:** `annotations`
- **Version:** `RELEASE`
- **Scope:** `compile`
- **Descrição:** Inclui anotações da JetBrains, como `@NotNull` e `@Nullable`, que ajudam a fornecer dicas para o compilador e IDEs, melhorando a qualidade do código.

## Plugins

### 1. **Spring Boot Maven Plugin**
- **GroupId:** `org.springframework.boot`
- **ArtifactId:** `spring-boot-maven-plugin`
- **Descrição:** Plugin que permite empacotar a aplicação Spring Boot como um JAR executável. Também facilita o gerenciamento do ciclo de vida da aplicação durante o desenvolvimento.

---