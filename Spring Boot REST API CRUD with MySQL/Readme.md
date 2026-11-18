# Student Management System — Spring Boot CRUD API

A RESTful Student Management application built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

This project demonstrates how to develop a backend application that performs Create, Read, Update, and Delete (CRUD) operations through REST APIs.

## 1. Project Overview

The Student Management System allows users to manage student records stored in a MySQL database.

Each student has:
- ID — Automatically generated student identifier.
- Name — Student's full name.
- Email — Student's email address.
- Age — Student's age.

## 2. Technologies Used

| Technology | Purpose |
|---|---|
| Java 23 | Programming language |
| Spring Boot 4.1.2 | Backend application framework |
| Spring WebMVC | REST API development |
| Spring Data JPA | Database operations |
| Hibernate | Object-relational mapping |
| MySQL 8 | Relational database |
| Maven | Dependency management and project building |
| IntelliJ IDEA | Development environment |
| Postman | REST API testing |

## 3. Project Structure

```text
studentmanagement/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/studentmanagement/
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── StudentService.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       │
│   │   │       └── StudentmanagementApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 4. Application Architecture

The application follows a layered architecture.

### Entity Layer
Defines the Student entity and maps it to the MySQL `students` table using JPA annotations.

### Repository Layer
Uses Spring Data JPA's `JpaRepository` to perform database operations without writing SQL queries manually.

### Service Layer
Contains the application's business logic and handles student creation, retrieval, updating, and deletion.

### Controller Layer
Exposes REST endpoints and receives HTTP requests from clients such as Postman.

### Request Flow

```text
Postman / Client
       |
       v
  Controller
       |
       v
    Service
       |
       v
   Repository
       |
       v
     MySQL
```

## 5. Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE student_management;
```

Configure the application in `application.properties`:

```properties
spring.application.name=studentmanagement

spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Important:** Replace the password placeholder with your local MySQL password. Never commit your actual database password to GitHub.

Hibernate automatically creates and updates the database table based on the Student entity.

## 6. Student Entity

The Student entity contains the following attributes:

| Field | Data Type | Description |
|---|---|---|
| id | Long | Primary key, auto-generated |
| name | String | Student name |
| email | String | Student email |
| age | Integer | Student age |

The entity uses:
- `@Entity`
- `@Table`
- `@Id`
- `@GeneratedValue`

## 7. REST API Endpoints

Base URL:

```text
http://localhost:8080/api/students
```

| Operation | HTTP Method | Endpoint |
|---|---|---|
| Create student | POST | `/api/students` |
| Get all students | GET | `/api/students` |
| Get student by ID | GET | `/api/students/{id}` |
| Update student | PUT | `/api/students/{id}` |
| Partially update student | PATCH | `/api/students/{id}` |
| Delete student | DELETE | `/api/students/{id}` |

### A. Create Student — POST

Endpoint:

```text
POST /api/students
```

Request body:

```json
{
    "name": "Abebe Kebede",
    "email": "abebe@gmail.com",
    "age": 22
}
```

Creates a new student record.

### B. Get All Students — GET

Endpoint:

```text
GET /api/students
```

Returns all student records.

### C. Get Student By ID — GET

Endpoint:

```text
GET /api/students/1
```

Returns a particular student using their ID.

### D. Update Student — PUT

Endpoint:

```text
PUT /api/students/1
```

Request body:

```json
{
    "name": "Abebe Updated",
    "email": "abebe.updated@gmail.com",
    "age": 23
}
```

Updates the student's information.

### E. Partially Update Student — PATCH

Endpoint:

```text
PATCH /api/students/1
```

Request body:

```json
{
    "email": "abebe.new@gmail.com"
}
```

Updates only the provided fields while keeping the other existing values unchanged.

### F. Delete Student — DELETE

Endpoint:

```text
DELETE /api/students/1
```

Deletes a student using their ID.

## 8. Running the Application

### Prerequisites

- Java Development Kit (JDK) 23
- MySQL Server
- IntelliJ IDEA
- Maven (or the included Maven Wrapper)
- Postman

### Steps

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Configure your MySQL database connection in `application.properties`.
4. Create the `student_management` database.
5. Allow Maven to download the dependencies.
6. Run `StudentmanagementApplication.java`.
7. Wait until the application starts on port 8080.
8. Use Postman to test the REST API endpoints.

### Run using Maven Wrapper

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## 9. Testing

The REST API endpoints are tested using Postman.

Testing includes:
- Creating student records.
- Retrieving all student records.
- Retrieving an individual student.
- Updating existing student information.
- Partially updating student information.
- Deleting student records.

Database records can also be verified using:

```sql
USE student_management;

SELECT * FROM students;
```

## 10. Learning Outcomes

Through this project, the following concepts were practiced:

- Creating a Spring Boot project using Spring Initializr.
- Understanding Maven dependencies.
- Connecting Spring Boot to MySQL.
- Understanding JPA and Hibernate.
- Mapping Java classes to database tables.
- Implementing the Repository, Service, and Controller layers.
- Using dependency injection and constructor injection.
- Developing REST APIs.
- Understanding HTTP methods: GET, POST, PUT, PATCH, and DELETE.
- Testing APIs using Postman.
- Verifying database operations using MySQL.

## 11. Author

**Yadeni Getu**

Software Engineering Student

Addis Ababa University

---

*This project was developed as a practical exercise to learn Spring Boot, REST API development, and database integration.*