## README - Assignment 2 in APP2000

This project was a part of the assessments I had when attending an application development subject (APP2000) at USN in Hønefoss. 
The focus of the assignment was to learn how to program simple CRUD methods in Spring Boot JPA. I focused on how to program a get, create and delete 
functions that I could use for the final exam in the subject, which is a fitness app we have to program the front- and backend for. 


## Requirements

- Java JDK 20 or above
  
- PostgreSQL database

- Maven

- An IDE for coding, for example IntelliJ IDEA


## Instructions

**Clone the repository**

1. Click on the Code button on the front page of the repository and copy the link.

2. Open git bash and change the direction of where you want the folder to be located (cd "C:/location").

3. Type git clone and paste the url to the repository.

4. Press enter to create the clone.


**Create the database**

5. Open pgAdmin and log in.

6. Click on databases and create a new database.

7. Call the database "myprojectdb".


**Link the database to the cloned repository**

8. Go to the application.properties file in the cloned repository folder.

9. Change spring.datasource.username= and spring.datasource.password= to your own username and password for the postgres database.


**Starting the project**

10. Go to the project terminal

11. Type mvn clean install, then mvn spring-boot:run

12. The project should now be available at http://localhost:8080 



## API Documentation

**Test the clone with Swagger**

1. Go through step 10 to 12 in the instructions.

2. Go to http://localhost:8080/swagger-ui.html in your browser.

3. To test a method, click on one of the functions listed under ApplikasjonsController.

4. Click "Try it out" and fill inn the required fields.

5. Press execute.

6. The Response from the program will now show up below.


## Examples of Using Swagger to Test the Endpoints

### [Get] Get a user by email

When using the get user by email method, it asks for the person to fill out the email address of the user. For this example,
I will be using "malin@mail.com".

The request url: ´http://localhost:8080/app/email/malin%40mail.com´

There are two possible responses from the database. The first is code 200, which means that the request was successfull. These cases will also include a response body, showing a simplified view of the information stored about the user in the database.
This view is simplified to protect sensitive information stored about the user, such as their password. Below is an example of how the body looks:

response body:

```json
{
  "userId": 1,
  "firstName": "malinator",
  "lastName": "tester",
  "email": "malin@mail.com"
}
```

If the request has not worked, we would have gotten an error code of 500 that means internal server error and a message in the terminal that says "The user does not exist".

### [Post] Creating a user

When creating a user, swagger requires the person to fill out a number of fields in a JSON body. These fields are required for a user to be registered in the database.
Below is an example of how the JSON body looks and how it can be used:

```json
{ 
  "firstName": "Hans", 
  "lastName": "Berg",
  "email": "Hans.Berg@mail.com",
  "password": "grønnsaker19",
  "dateOfBirth": "1999-12-12"
}
```

Once executed, the database will either respond with code 200 or code 500. Code 200 means that the user was registered, and includes a simplified view of the information about the user saved in the database:

```json
{
  "userId": 202, 
  "firstName": "Hans",
  "lastName": "Berg",
  "email": "Hans.Berg@mail.com"
}
```

Code 500 on the other hand, means that the user cannot be created due to internal server error. One example of this is if the email has already been used to register another user. In this case, this will also raise an error in the terminal and say "Email is already in use".

### [Delete] Deleting a user

When deleting a user, swagger will ask the person to fill out the email address of the user. One example of this is "malin@mail.com", which I used in the GET example.

The request url: ´http://localhost:8080/app/malin%40mail.com´

Once executed, this will return code 204 and 200, or just code 500. The first response means that the user and all its registered activities has been deleted from the database. The second response means means that the user was not found in the database, and therefore cannot be deleted.



## Project Structure

```
src/main/java/org.example.Applikasjonsutviklingsarbeidskrav/
├── controller/      # REST controllers
├── model/           # Entity classes
├── repository/      # Data access layer
├── service/         # Business logic
├── dto/             # Data Transfer Objects
├── mapper/          # Object mappers
└── exception/       # Exception handling
```

## Key Components

Here are some of the key components used in this project

### Entities

`User` represents a registered user of the system. It includes:

- userId (primary key)

- firstName

- lastName

- emailAddress

- password

- dateOfBirth


`Activity` represents an activity that a user has registered. It includes:

- activityId (primary key)

- description

- duration

- accessibility

- published

- publisher


### Repository

`UserRepository` and `ActivityRepository` holds methods that directly interact with the data in the database:

- Both include basic CRUD operations from the JpaRepository

- `UserRepository` also include..
  - `findByEmail` function that finds a user by their email address,
    
  - `save` method that saves the user to the database. 


### Service

`ApplikasjonsService` Implements business logic in the database:

- get user by email

- create user

- delete user


### Controller

`ApplikasjonsController` Defines the REST endpoints:

- GET `/app/getUser/{email}` - Get user by email address. 

- POST `/app/createUser` - Register a new user in the database

- DELETE `/app/deleteUser` - Delete a registered user in the database
