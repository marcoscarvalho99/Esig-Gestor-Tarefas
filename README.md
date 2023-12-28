# Gestor de Tarefas
Um pequeno Sistema criado para uma avaliação de estagio na [ESIG](https://esig.group/).

### Arquitetura ultilizada

Tecnologias ultilizadas
* [Spring Initialyzer](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Official Apache Maven](https://maven.apache.org/guides/index.html)
* [Spring MVC](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Bootstrap](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Banco H2](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [ Jpa Repositories](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)

### Guia de uso do Sistema

O sistema possui tais requisitos para funcionar corretamente: JAVA 17, uma JDK correto-19, e a configuração do banco de dados no sistema. 
A configuração abaixo usada no application.properties já faz toda essa configuração do banco para testes:

Copie os campos abaixo e cole em seu arquivo application.properties:
* spring.datasource.url=jdbc:h2:mem:testdb
* spring.datasource.driverClassName=org.h2.Driver
* spring.datasource.username=sa
* spring.datasource.password=password
* spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
 
### Apos o sistema executar na IDE
#### URLS de acesso as telas do sistema

* Cadastrar uma nova atividade: http://localhost:8080/tarefa
* Listar todas as atividades: http://localhost:8080/tarefa/listAll
