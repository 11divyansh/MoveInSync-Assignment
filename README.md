# MoveInSync-Assignment
# Book Store API - Microservices Architecture

This is a Java Spring Boot application that provides a RESTful API for managing books, users, and inventory in a microservices-style structure (combined in a single project for simplicity). It supports basic CRUD operations and is ready to be extended with authentication and inter-service communication.
---
## Features
- Book Management (Add, Edit, Delete, View)
- User Management (Register, View)
- Inventory Tracking (Stock per book)
- Ready for JWT integration
- Swagger API Documentation enabled
---
## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (or any other RDBMS)
- Swagger UI (via springdoc-openapi)
- Maven
---
## Project Structure

```bash
.
├── src
│   └── main
│       ├── java
│       │   └── com.example.bookstore
│       │       ├── controller
│       │       ├── service
│       │       ├── model
│       │       └── repository
│       └── resources
│           ├── application.properties
├── pom.xml
└── README.md
⚙️ Setup Instructions
---
Prerequisites
-Java 17+
-Maven
-MySQL

Clone the repository
-git clone https://github.com/11divyansh/bookstore-microservices.git
-cd bookstore-microservices

Configure the Database
-Update src/main/resources/application.properties:

properties
-server.port=8081
#Swagger config
-springdoc.swagger-ui.path=/swagger-ui.html

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
-spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
-spring.datasource.username=your_username
-spring.datasource.password=your_password

s-pring.jpa.hibernate.ddl-auto=update
-spring.jpa.show-sql=true

Run the Application
mvn spring-boot:run

API Documentation
Swagger UI is available at:
-http://localhost:8081/swagger-ui/index.html
