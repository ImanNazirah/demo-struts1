<p align="center" style="background-color: #3157a7; padding: 20px;"><a href="https://weblegacy.github.io/struts1/" target="_blank"><img src="https://struts.apache.org/img/struts-logo.svg" width="100"></a></p>

![Status](https://img.shields.io/badge/status-Completed-brightgreen)

# Simple CRUD Application Using Struts 1 and Hibernate

## Overview

This is a simple web application built using Struts 1 for the presentation layer and Hibernate for data persistence. The application demonstrates basic CRUD (Create, Read, Update, Delete) operations.

## Features

- **CRUD Operations with Struts1:** Implemented full Create, Read, Update, and Delete (CRUD) operations using Struts1 framework to manage data flow and user interaction seamlessly.
- **Reusable Components with Tiles:** Utilized Apache Tiles for efficient layout management, allowing for reusable templates and consistent page structure across the application.
- **Authentication:** Implemented user authentication mechanisms to secure the application, ensuring only authorized users can access certain functionalities.

## Technologies Used

- **Struts 1:** MVC framework for the presentation layer.
- **Hibernate:** ORM framework for database interactions.
- **MySQL:** Relational database to store information.
- **Jetty:** Embedded server for running the application.

## Setup Instructions

1. Configure the Database

Create a MySQL database named demo and run the following SQL script from demo.sql.

2. Configure Hibernate


Update the hibernate.cfg.xml file in the src/main/resources folder with your MySQL database connection details:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/demo</property>
<property name="hibernate.connection.username">your-username</property>
<property name="hibernate.connection.password">your-password</property>
```

3. Build the Project

```bash
mvn clean install -DskipTests
```

4. Run Application

```bash
mvn jetty:run
```

5. Access the Application

Open your browser and go to:

http://localhost:8080/demo-struts1/login.do

```txt
username : demo_test1
password : mypassword
```

## References

- https://weblegacy.github.io/struts1/

