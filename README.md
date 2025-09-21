# To-Do List API

Uma **REST API** simples desenvolvida em **Spring Boot** para gerenciar tarefas (**To-Do List**).  
O projeto utiliza o banco de dados **H2 (em memória)** para persistência, ideal para testes e desenvolvimento rápido.

---

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

---

##  Estrutura do Projeto
- **Model** → Representa a entidade `Tarefa`.
- **Repository** → Interface que comunica com o banco de dados.
- **Service** → Contém as regras de negócio da aplicação.
- **Controller** → Exposição dos endpoints REST.

---

## Configuração do Projeto
O banco de dados **H2** está configurado no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:todolist
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
