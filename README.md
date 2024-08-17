# Simple CRUD Application Using Struts 1 and Hibernate

## Overview

This is a simple web application built using Struts 1 for the presentation layer and Hibernate for data persistence. The application demonstrates basic CRUD (Create, Read, Update, Delete) operations on a `Spotify` entity.

## Features

- **Create:** Add a new data to the database.
- **Read:** View details of all data.
- **Update:** Modify details of an existing data.
- **Delete:** Remove a data from the database.


## Technologies Used

- **Struts 1:** MVC framework for the presentation layer.
- **Hibernate:** ORM framework for database interactions.
- **MySQL:** Relational database to store information.
- **Jetty:** Embedded server for running the application.


## Setup Instructions

1. Configure the Database


Create a MySQL database named demo and run the following SQL script to create the Spotify table:

https://github.com/ImanNazirah/demo/blob/master/demo.sql

2. Configure Hibernate


Update the hibernate.cfg.xml file in the src/main/resources folder with your MySQL database connection details:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/demo</property>
<property name="hibernate.connection.username">your-username</property>
<property name="hibernate.connection.password">your-password</property>
```

4. Build the Project

```bash
mvn clean install
```

5. Run Application

```bash
mvn jetty:run
```

6. Access the Application


Open your browser and go to:

| Routes       | Purpose      |
|--------------|--------------|
| http://localhost:8080/demo-struts1/test.do | Testing page |
| http://localhost:8080/demo-struts1/spotifyList.do | View All listing |
| http://localhost:8080/demo-struts1/spotifyPagination.do?page=1 | View lisitng with pagination |



