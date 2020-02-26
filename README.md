# Clip  Interview- Transaction API

## Getting Started

Microservice Restful API to manage transactions operations and services. 

### Prerequisites

- [JDK 1.8 or later](https://www.oracle.com/java/technologies/javase-downloads.html)

- [Gradle 6+](https://gradle.org/install/)

- [Docker](https://docs.docker.com/install/)

- [Docker Compose](https://docs.docker.com/compose/)

  

### Installation

1. Clone the repository

   ```
   git clone https://github.com/martinrzg/martin-ruiz-sample-java-test
   cd martin-ruiz-sample-java-test
   ```

2. Building the project

   ```
   ./gradlew build
   ```

3. Deploying the app locally

   ```
   docker-compose up -d --build
   ```

4. App runs at localhost:8080/api, you can use the health-check actuator to ensure everything is working fine

   ```
   curl --location --request GET 'localhost:8080/api/actuator/health'
   ```

5. Review de SwaggerUI API Docs, explore and play with the endpoints. 

   ```
   http://localhost:8080/api/swagger-ui.html
   ```

**Sidenote:**

- For easy validation there is a migration with dummy data generates transactions for user **123**. 

## Technology Stack

### Built with

- Java 1.8
- Kotlin 1.3
- [SpringBoot 2.2.4.RELEASE](https://spring.io/projects/spring-boot)
- [Gradle](https://gradle.org/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/)
- [Flyway](https://flywaydb.org/)
- [Swagger](https://swagger.io/)

## Features
- Swagger UI API Docs
- Flyway Database migrations and version control
- Spring Actuator for health check
- Dockerfile for build image
- Docker-compose easy deployment of all the environment
- Spring profiles
- Exception Handler
- Build Gradle Kotlin DSL 

## API Reference/Docs

Swagger live API docs located at http://localhost:8080/api/swagger-ui.html

## Tests
Junit 5, **WIP**.

## License
Distributed under the MIT License © [MartinRuiz](https://github.com/martinrzg)
