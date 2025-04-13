# Bank Application

A modular banking system application built with Spring Boot that handles credit applications and customer management.

## Project Structure

The project follows a modular architecture with the following components:

- **credit-system-core**: Core utilities, exception handlers, and common components
- **credit-system-entities**: Domain entities and data models
- **credit-system-repositories**: Data access layer and repository implementations
- **credit-system-business**: Business logic and service implementations
- **credit-system-webapi**: REST API endpoints and controllers

## Technologies

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- MapStruct
- Lombok
- Swagger/OpenAPI

## Features

- Customer Management (Individual & Corporate)
- Credit Type Management
- Credit Application Processing
- Role-based Access Control
- RESTful API Design
- Modular Architecture
- Exception Handling
- Validation
- Pagination Support

## Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL

## Installation

1. Clone the repository:
```bash
git clone https://github.com/erenciceek/bank-app.git
```

2. Navigate to the project directory:
```bash
cd bank-app
```

3. Create a PostgreSQL database named 'credit_system'

4. Configure the database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/credit_system
spring.datasource.username=your_username
spring.datasource.password=your_password
```

5. Build the project:
```bash
mvn clean install
```

6. Run the application:
```bash
cd credit-system-webapi
mvn spring-boot:run
```

## API Documentation

Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## Project Structure Details

### Core Module
- Exception handling
- Utilities
- Common components
- Cross-cutting concerns

### Entities Module
- Domain models
- JPA entities
- Base entity classes

### Repositories Module
- Data access interfaces
- JPA repositories
- Custom query methods

### Business Module
- Business logic
- Service implementations
- DTOs and mappers
- Business rules

### WebAPI Module
- REST controllers
- Request/Response handling
- API documentation
- Security configuration

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. 