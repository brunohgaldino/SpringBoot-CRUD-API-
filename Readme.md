Spring Boot, PostgreSQL, REST API em exmeplo CRUD

Métodos implementados:

Cadastro, alteração, exclusão e visualização.

Tecnoclogias utilizadas:

Spring Boot
Spring Data
Maven
Postman
Junit
Docker
PostgresSQL


Para rodar o APP, utilizar o comando dentro da pasta root do projeto:
mvn spring-boot:run

Comando docker:
docker run -p 5432:5432 --name DemoSpring -e POSTGRES_PASSWORD=123456 -d postgres

NA raiz, está disponibilizado collection do postman
