# Product Catalog API

A RESTful API built with Spring Boot 3 that performs CRUD operations on an e-commerce product catalog. This project supports data validation, error handling, and interactive API documentation with Swagger.

## Overview

The Product Catalog API is designed for a full-stack assessment. It demonstrates proficiency in backend development with Java 17 and Spring Boot as well as integration with a React-based frontend. The API uses an in-memory H2 database for development and can be easily configured to use PostgreSQL in other environments.

## Features

- **CRUD Operations:** Create, read, update, and delete products and categories.
- **Data Validation:** Leveraging Bean Validation (JSR 380) for reliable input handling.
- **Global Error Handling:** Consistent error responses for invalid requests.
- **API Documentation:** Automatically generated documentation using Swagger (Springdoc OpenAPI).
- **Flexible Database Configuration:** H2 for local testing with easy migration to PostgreSQL.

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Springdoc OpenAPI (Swagger)**
- **H2 Database** (for development)
- **PostgreSQL** (for production, configurable via properties)
- **Maven**

## Prerequisites

- **Java 17** installed on your system
- **Maven** for building the project
- Your preferred IDE (e.g., IntelliJ IDEA, Eclipse, or VSCode)

## Getting Started

### Clone the Repository

```bash
git clone https://your-repository-url.git
cd product-catalog
```


## Build the Project
Run the following command from the project root:

```bash
mvn clean install
Run the Application
```

Start the application using Maven:

```bash
mvn spring-boot:run
```
### The API will be available at http://localhost:8080.

#  Configuration
## Database
- he application uses an in-memory H2 database for development. You can find the configuration in src/main/resources/application.properties:

```properties
spring.datasource.url=jdbc:h2:mem:catalogdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
For production, update these properties to point to a PostgreSQL database.
```

# API Endpoints
## Authentication
- POST /auth/login: Authenticate a user.
- POST /auth/register: Register a new user.

## Products
- GET /products: Retrieve all products.
- GET /products/{id}: Retrieve a specific product by its ID.
- POST /products: Create a new product.
- PUT /products/{id}: Update an existing product.
- DELETE /products/{id}: Delete a product.

## Categories
- GET /categories: Retrieve all categories.
- GET /categories/{id}: Retrieve a specific category by its ID.
- POST /categories: Create a new category.
- PUT /categories/{id}: Update a category.
- DELETE /categories/{id}: Delete a category.

## Documentation
#### Interactive API documentation is available using Swagger. Access it at:
- http://localhost:8080/swagger-ui/index.html

If you prefer a different path, you can configure the Swagger UI path in the application.properties file.


# Contributing
- Contributions are welcome! Please submit a pull request or open an issue if you have any suggestions or improvements.