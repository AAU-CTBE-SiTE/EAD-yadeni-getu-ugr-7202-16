# Java JDBC MySQL Connection

## Project Description

This project demonstrates how to connect a Java application to a MySQL database using JDBC (Java Database Connectivity).

## Technologies Used

* Java 23
* MySQL
* JDBC
* MySQL Connector/J 9.5.0
* Maven
* IntelliJ IDEA

## Database Details

* Database: `StudentsDB`
* Table: `students`
* Columns: `id`, `firstname`, `lastname`, `grade`

## Features

1. Registers the MySQL JDBC driver.
2. Establishes a connection to the MySQL database.
3. Executes a SQL query to retrieve student records.
4. Displays the retrieved records.
5. Closes the database resources.
6. Displays an error message if the connection fails.

## How to Run

1. Install Java and MySQL.
2. Create the `StudentsDB` database and `students` table.
3. Configure the `DB_USERNAME` and `DB_PASSWORD` environment variables in the Java run configuration.
4. Open the project in IntelliJ IDEA.
5. Allow Maven to download the project dependencies.
6. Run `org.example.Main`.

## Expected Output

The program should display a successful connection message and the student records returned by the database.

## Security

Database credentials are provided through environment variables and are not stored in the source code.
