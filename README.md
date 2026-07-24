# 🎫 Support Ticket API

A RESTful API built with **Spring Boot** for managing support tickets. This project demonstrates CRUD operations, the DTO pattern, global exception handling, Spring AOP, and a layered architecture following Spring Boot best practices.

---

## 🚀 Features

* Create a new support ticket
* Retrieve all support tickets
* Retrieve a support ticket by ID
* Update an existing support ticket
* Delete a support ticket
* DTO pattern for API requests and responses
* Global exception handling using `@ControllerAdvice`
* Execution time logging using Spring AOP
* H2 in-memory database
* RESTful API design

---

## 🛠️ Technologies Used

* Java 21
* Spring Boot 3.5.x
* Spring Web
* Spring Data JPA
* Hibernate
* Spring AOP
* H2 Database
* Maven
* Lombok

---

## 📂 Project Structure

```text
src
├── annotation
├── aspect
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

## 📌 API Endpoints

| Method | Endpoint            | Description                       |
| ------ | ------------------- | --------------------------------- |
| GET    | `/api/tickets`      | Retrieve all support tickets      |
| GET    | `/api/tickets/{id}` | Retrieve a support ticket by ID   |
| POST   | `/api/tickets`      | Create a new support ticket       |
| PUT    | `/api/tickets`      | Update an existing support ticket |
| DELETE | `/api/tickets/{id}` | Delete a support ticket           |

---

## 🗄️ H2 Database

The project uses an **H2 in-memory database** for development and testing.

Open the H2 Console:

```text
http://localhost:8080/h2-console
```

Configuration:

| Property | Value                                 |
| -------- | ------------------------------------- |
| JDBC URL | `jdbc:h2:mem:testdb`                  |
| Username | `sa`                                  |
| Password | *(blank or your configured password)* |

---

## ⚡ Spring AOP

This project uses **Spring AOP** with a custom `@LogExecutionTime` annotation to measure and log the execution time of annotated methods.

---

## 📚 Learning Objectives

This project demonstrates:

* Building RESTful APIs with Spring Boot
* Layered Architecture (Controller, Service, Repository)
* DTO Design Pattern
* Spring Data JPA and Hibernate
* Global Exception Handling
* Spring AOP (Aspect-Oriented Programming)
* Clean and Maintainable Code

---

## 👨‍💻 Author

**Hossien Rafieemanesh**

**GitHub Repository:**
https://github.com/hossien-rm/Support-Ticket-APIs

