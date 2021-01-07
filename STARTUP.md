# Startup Guide for Caliber Staging Module
This document should serve as guide to setting up the project on your own machine.
## Service Layer
### Java
1. Install Java 8 JDK.
2. Pull project from GitHub repository.
3. Import project into your IDE as a Maven project.
4. Ensure that the following dependencies are part of the project
    - Spring Boot version 2.4.1:
        - Spring JDBC
        - Spring JPA
        - Spring Web
        - Spring Dev-Tools
        - Spring Test
    - Postgresql Driver for database connectivity, if using a different SQL dialect make sure you have the correct SQL driver for it.
    - H2 Database used for testing without persisting to a database.
    - JUnit 4 for testing
    - Mockito for mocking Service & Repository layers
    - Log4j for logging.
5. Update the application.properties within src/main/resources to point to the correct database & port that you intend to use with the project. By Default the port is: 8081
6. Read the README.md & look over the pre-existing codebase to gain an understanding of the project.
### Database
1. Launch either a PostgreSQL RDS on AWS or Host a PostgreSQL database on your local machine. 
2. Update the *spring.datasource.url* property within the application.properties file to match the new RDS url.
3. Run the Java application to populate the new database with the correct tables.

## Angular Layer
1. Install the latest version of Node.js & the Node Package Manager (NPM)
2. Run npm install @angular/cli to install the latest version of Angular from the terminal.
3. Open project in your preferred IDE, we used Visual Studio Code, and open the terminal.
4. Run npm install to install all dependencies needed for the project.
5. Look over the README.md & codebase to gain an understanding of the project.

## Deployment

       