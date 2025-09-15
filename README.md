# PerfectCrud Demo Project

## Overview

PerfectCrud is a demo Spring Boot project showcasing a clean, layered architecture for CRUD operations on `Workspace`
and `Team` entities. The project uses modern best practices, including DTOs, MapStruct for mapping, and OpenAPI for
documentation.

## Technologies

- Java `17`
- Gradle `8.14.3`
- Spring Boot `3.5.4`
- Spring Data JPA
- Spring Web
- PostgreSQL
- Liquibase
- Lombok
- MapStruct
- OpenAPI (Swagger)
- Jakarta Validation

## Architecture

The project follows a layered architecture:

- **Controller Layer**: Handles HTTP requests and responses. Uses DTOs for input/output and delegates business logic to
  the UseCase layer.
- **UseCase Layer**: Encapsulates application-specific business scenarios. Acts as a bridge between controllers and
  services.
- **Service Layer**: Contains core business logic and interacts with repositories.
- **Repository Layer**: Manages data persistence using Spring Data JPA.
- **Mapper Layer**: Uses MapStruct to convert between entities and DTOs.
- **DTO Layer**: Defines request, response, and model DTOs for data transfer between layers.
- **Model Layer**: Contains JPA entities representing database tables.
- **Exception Layer**: Handles custom exceptions and global error handling.
- **Config Layer**: Stores configuration classes, including OpenAPI and exception handling advice.
- **Properties Layer**: Manages properties from application.yml.

## Directory Structure

```
src/main/java/ru/feodorkek/dev/perfectcrud/
├── config/           # Configuration classes (OpenAPI, Exception Advice)
├── controller/       # REST controllers
├── dto/              # Data Transfer Objects (model, request, response)
├── exception/        # Custom exceptions
├── mapper/           # MapStruct mappers
├── model/            # JPA entities (with base entities for auditing)
├── properties/       # Properties classes (Rest API properties)
├── repository/       # Spring Data JPA repositories
├── service/          # Service interfaces and implementations
├── usecase/          # UseCase interfaces and implementations
```

## Entities

- **Workspace**: Represents a workspace entity.
- **Team**: Represents a team entity.

## Features

- Entities are immutable with Lombok.
- CRUD operations for Workspace and Team entities.
- Layered separation for maintainability and scalability.
- DTOs for request/response validation and data encapsulation.
- MapStruct for efficient mapping between entities and DTOs.
- OpenAPI integration for auto-generated API documentation.
- Centralized exception handling.

## How to Run

1. Clone the repository.
2. Set up required environment variables.
3. Run `./gradlew bootRun` or use your IDE to start the application.
4. Access the API documentation at `/swagger-ui.html`.

## Environment Variables

| Variable            | Type    | Description                                  | Example Value                                   |
|---------------------|---------|----------------------------------------------|-------------------------------------------------|
| `PORT`              | number  | Port for running the application             | `8080`                                          |
| `DATABASE_URL`      | string  | PostgreSQL database connection URL           | `jdbc:postgresql://localhost:5432/perfect_crud` |
| `DATABASE_USERNAME` | string  | Database username                            | `postgres`                                      |
| `DATABASE_PASSWORD` | string  | Database password                            | `postgres`                                      |
| `JPA_SHOW_SQL`      | boolean | Show SQL queries in logs (`true` or `false`) | `false`                                         |

## License

This project is for demo purposes.