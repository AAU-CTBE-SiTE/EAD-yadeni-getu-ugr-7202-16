# JPA Lab 2 — Student Management System

## Overview

This project demonstrates Java Persistence API (JPA) with Hibernate ORM and a MySQL database. It implements a student management system that performs Create, Read, Update, and Delete (CRUD) operations and demonstrates JPQL queries for retrieving and manipulating student records.

## Technologies Used

- **Java** — application programming language
- **Maven** — project and dependency management
- **Jakarta Persistence API (JPA)** — object-relational persistence
- **Hibernate ORM** — JPA implementation
- **MySQL** — relational database
- **IntelliJ IDEA** — development environment

## Project Structure

```text
lab2-jpa/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── craft/
        │           ├── App.java
        │           └── Student.java
        └── resources/
            └── META-INF/
                └── persistence.xml
```

## Main Features

### 1. CRUD Operations

- **Create:** Add a student to the database.
- **Read:** Retrieve a student by ID or retrieve all students.
- **Update:** Change a student's name.
- **Delete:** Remove a student by ID.

### 2. JPQL Queries

The project includes queries demonstrating:

- Searching students by name and technology
- Case-insensitive name searches
- Pattern matching with `LIKE`
- Filtering by ID and ranges
- Sorting and pagination
- Counting students and grouping by technology
- Aggregate functions such as `AVG`, `MAX`, `MIN`, and `SUM`
- Subqueries and `EXISTS`
- Bulk update and delete operations

## Database Configuration

Create a MySQL database named `jpadb1` before running the application.

Database connection details are configured in:

`src/main/resources/META-INF/persistence.xml`

Update the database username and password to match your local MySQL configuration. Do not commit real passwords or other secrets to a public repository.

## How to Run

1. Install a compatible JDK and MySQL Server.
2. Create the `jpadb1` database in MySQL.
3. Open the `lab2-jpa` project in IntelliJ IDEA.
4. Check the dependencies in `pom.xml`.
5. Verify the database connection settings in `persistence.xml`.
6. Reload the Maven project.
7. Run `com.craft.App`.

The `main()` method demonstrates the CRUD workflow by creating a test student, reading it, updating its name, and deleting it.

## Learning Outcomes

This lab provides practical experience with:

- Mapping Java classes to database tables using JPA entities
- Managing persistence with `EntityManager`
- Using transactions for database modifications
- Configuring Hibernate and MySQL
- Writing JPQL queries
- Managing dependencies with Maven

## Academic Context

Enterprise Application Development — Lab 2 (JPA)

