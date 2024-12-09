# X-Ticket Backend API

X-Ticket is a backend API for managing events, tickets, users, and more. This project is built using Spring Boot, Spring Data JPA, and PostgreSQL. It includes Swagger for API documentation and Lombok for reducing boilerplate code.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- User management
- Event management
- Ticket management
- Payment processing
- Review system
- Swagger API documentation

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi) or [Gradle](https://gradle.org/releases/)
- [PostgreSQL](https://www.postgresql.org/download/)

## Installation

### Using Maven

1. **Clone the repository**:

    ```sh
    git clone https://github.com/yourusername/x-ticket.git
    cd x-ticket
    ```

2. **Build the project**:

    ```sh
    mvn clean install
    ```

3. **Run the application**:

    ```sh
    mvn spring-boot\:run
    ```

### Using Gradle

1. **Clone the repository**:

    ```sh
    git clone https://github.com/yourusername/x-ticket.git
    cd x-ticket
    ```

2. **Build the project**:

    ```sh
    ./gradlew clean build
    ```

3. **Run the application**:

    ```sh
    ./gradlew bootRun
    ```

## Usage

Once the application is running, you can access the API endpoints. The default port is `8080`.

### Example Endpoints

- **Get all users**: `GET /api/users`
- **Get a user by ID**: `GET /api/users/{id}`
- **Create a new user**: `POST /api/users`
- **Update a user**: `PUT /api/users/{id}`
- **Delete a user**: `DELETE /api/users/{id}`

## API Documentation

The API documentation is available via Swagger UI. You can access it at:

