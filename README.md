# Support Ticket API

A RESTful Support Ticket API built with **Java 21** and **Spring Boot 3.5.x**. This project demonstrates CRUD operations, DTO implementation, exception handling, and Spring Data JPA with an in-memory H2 database.

---

## Features

- Create a new support ticket
- Retrieve all support tickets
- Retrieve a support ticket by ID
- Update an existing support ticket
- Delete a support ticket
- Custom exception handling
- DTO pattern for API requests and responses

---

## Technologies Used

- Java 21
- Spring Boot 3.5.x
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Lombok

---

## H2 Database

After starting the application, open the H2 Console:

**URL**
```
http://localhost:8080/h2-console
```

**Connection Details**

| Property | Value |
|----------|-------|
| JDBC URL | `jdbc:h2:mem:testdb` |
| Username | `sa` |
| Password | *(leave empty)* |

---

## REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/tickets` | Retrieve all support tickets |
| GET | `/tickets/{id}` | Retrieve a support ticket by ID |
| POST | `/tickets` | Create a new support ticket |
| PUT | `/tickets` | Update an existing support ticket |
| DELETE | `/tickets/{id}` | Delete a support ticket |

---

## Project Structure

```
src
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
├── service
└── SupportTicketApiApplication.java
```

---

## Running the Application

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Ensure Java 21 is installed.
4. Run the application.
5. Access the H2 Console:
   ```
   http://localhost:8080/h2-console
   ```

---

## Author

**Hossien Rafieemanesh**
