# AG - Avaliação Técnica 
Detalhamento de cada dependência do arquivo `pom.xml`:

### Dependências do Projeto

#### Java 17
```xml
  <java.version>17</java.version>
```

#### JUnit 5
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
</dependency>
```
- **Propósito**: Fornece bibliotecas para testes unitários utilizando JUnit 5.
- **Scope**: `test` - utilizado apenas durante a fase de teste.

#### Spring Boot Starter Data JPA
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
- **Propósito**: Fornece suporte para trabalhar com JPA (Java Persistence API) usando Spring Data JPA, facilitando a implementação de repositórios.

#### Spring Boot Starter Web
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- **Propósito**: Fornece bibliotecas necessárias para criar aplicações web RESTful usando Spring MVC.

#### Flyway Core
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```
- **Propósito**: Gerencia versões e migrações do banco de dados de forma eficiente e controlada.

#### Flyway Database PostgreSQL
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-database-postgresql</artifactId>
</dependency>
```
- **Propósito**: Fornece suporte específico para migrações de banco de dados PostgreSQL utilizando Flyway.

#### Spring Boot DevTools
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```
- **Propósito**: Facilita o desenvolvimento, oferecendo funcionalidades como reinicialização automática e live reload.
- **Scope**: `runtime` - utilizado em tempo de execução.
- **Optional**: `true` - é opcional, não sendo necessária em todos os contextos.

#### PostgreSQL
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
- **Propósito**: Driver JDBC para conectar-se a um banco de dados PostgreSQL.
- **Scope**: `runtime` - utilizado em tempo de execução.

#### Lombok
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```
- **Propósito**: Facilita a criação de código boilerplate, como getters, setters e construtores.
- **Optional**: `true` - é opcional, podendo ser excluído em alguns contextos.

#### Spring Boot Starter Test
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```
- **Propósito**: Fornece um conjunto abrangente de dependências para testes utilizando Spring Boot.
- **Scope**: `test` - utilizado apenas durante a fase de teste.

### Configurações de Build

#### Spring Boot Maven Plugin
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <excludes>
            <exclude>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </exclude>
        </excludes>
    </configuration>
</plugin>
```
- **Propósito**: Simplifica o processo de empacotamento e execução de aplicações Spring Boot.
- **Configuração**: Exclui a dependência `lombok` durante o empacotamento da aplicação.

_________________
## Coverege 

Conforme solicitado, atualmente a cobertuda de teste unitário está a cima de 80%

![image](https://github.com/AndersonGalindro/AG/assets/34112032/a864f6ca-9a26-452b-bbfa-64c42fc0c0c7)
_________________
## Banco de dados

![image](https://github.com/AndersonGalindro/AG/assets/34112032/28b0b116-f1bd-463a-ad96-05800e9a281a)
_________________

# Util
 -  Inicialmente eu havia pensado em colocar uma carga no banco de dados, utilizando o flyway, mas, resolvi criar uma collection e juntamente a mesma uma Environment, Então é só importar para o postman e utilizar, ambos estão na raíz do projeto com os respectivos nome Sistema de Gestão de Projetos.postman_collection.json e New Environment.postman_environment.json
- Gostaria de deixar claro que aqui só se encontra o Back-end do desafio, já que a recrutadora afirmou que no momento busca um profissional Java Senior com conhecimento em Javascript
- ![image](https://github.com/AndersonGalindro/AG/assets/34112032/e81193f2-5bf9-482c-943d-8bd0884be1ed)
- Se necessário, posso apresentar algum outro projeto em AngularJS como parte do meu trabalho com a linguagem Javascript

