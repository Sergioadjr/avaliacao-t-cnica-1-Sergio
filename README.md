*Desafio*
Este é um projeto, cuja finalidade é a demonstração da capacidade técnica, com objetivo de selecionar e classificar as famílias 
aptas a ganharem uma casa popular, conforme critérios predefinidos.

*Dependências*
O projeto possui as seguintes dependências:
Spring Boot Starter Data JPA
Spring Boot Starter Web
Spring Boot DevTools
H2 Database
PostgreSQL JDBC Driver
Project Lombok
Spring Boot Starter Test

*Requisitos*
Java 17 ou superior

*Como executar o projeto*
Para executar o projeto em máquina local:

* Certifique-se de ter o *Java 17 ou superior* instalado em seu sistema.
* Clone este repositório para o seu diretório local.
* Navegue até o diretório do projeto: cd Desafio.
* Execute o seguinte comando para compilar o projeto: *mvn compile*.
* Em seguida, execute o comando para executar o projeto: *mvn spring-boot:run*.
* O projeto será executado localmente em http://localhost:8080.

*Documentação da API*
A documentação da API está disponível no seguinte endpoint: http://localhost:8080/swagger-ui.html.
Certifique-se de que o projeto esteja em execução antes de acessar o link.

*Notas adicionais*
O projeto utiliza o plugin do Maven spring-boot-maven-plugin para compilação e execução.
A dependência lombok está configurada como opcional e é excluída no processo de compilação do Maven.
Certifique-se de ter as dependências corretas configuradas em seu ambiente antes de executar o projeto.
