Project setup instructions
API documentation
Examples of API usage

**README - Assignment 2 in APP2000**
This project was a part of the assessments I had when attending an application development subject (APP2000) at USN in Hønefoss. The focus of the assignment was to learn how to program simple CRUD methods in Spring Boot JPA. I focused on how to program a get, create and delete functions that I could use for the final exam in the subject, which is a fitness app we have to program the front- and backend for. 

**Requirements**
- Java JDK 20 or above
- PostgreSQL database
- Maven

**Instructions**
In order to use the project, you first have to copy the repository.

*Clone the repository*
1. Click on the Code button on the front page of the repository and copy the link.
2. Open git bash and change the direction of where you want the folder to be located (cd "C:/location").
3. Type git clone and paste the url to the repository.
4. Press enter to create the clone.

*Create the database*
5. Open pgAdmin and log in.
6. Click on databases and create a new database.
7. Call the database "myprojectdb".

*Link the database to the cloned repository*
8. Go to the application.properties file in the cloned repository folder.
9. Change spring.datasource.username= and spring.datasource.password= to your own username and password for the postgres database.

*Launch and test the clone*
10. Go to the project terminal and type "mvn clean install"
11. After recieving "Build Success", type "mvn spring-boot:run"
12. Go to swagger (http://localhost:8080/swagger-ui/index.html#/ApplikasjonsController) and use the methods to interact with the database

**API Documentation**
