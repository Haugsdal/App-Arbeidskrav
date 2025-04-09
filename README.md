## Tech Stack

- Java 21
- Spring Boot 3.2.2
- PostgreSQL
- OpenAPI (Swagger) for documentation
- MapStruct for object mapping
- Lombok for reducing boilerplate code

## Prerequisites

Before you begin, ensure you have:
- JDK 21
- Maven
- PostgreSQL
- Your favorite IDE (preferably IntelliJ IDEA)

## Getting Started

1. Clone the repository
2. Create PostgreSQL database:
```sql
CREATE DATABASE mailserver;
```

3. Configure database connection in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mailserver
spring.datasource.username=your_username (most likely 'postgres')
spring.datasource.password=your_password
```
4. Make sure the last line looks like this:
```properties
spring.jpa.hibernate.ddl-auto=create
```

5. Build the project:
```bash
mvn clean install
```

6. Run the application:
```bash
mvn spring-boot:run
```

7. Afterwards you should change this line from:
```properties
spring.jpa.hibernate.ddl-auto=create
```
to 
```properties
spring.jpa.hibernate.ddl-auto=update
```

The application will be available at `http://localhost:8080`

## API Documentation

Access the Swagger UI to explore and test the API:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### Testing with Swagger UI

1. Start your Spring Boot application
2. Go to `http://localhost:8080/swagger-ui.html` in your browser
3. Explore and test the available endpoints:
    - Expand the "Mail Controller" section to see all endpoints
    - Click on an endpoint (e.g., GET `/api/v1/app_user`)
    - Click "Try it out", then "Execute"
    - View the response

### Testing with Postman

1. Download and install [Postman](https://www.postman.com/downloads/)
2. Create requests for the following endpoints:
   - GET `/api/mail/{id}` - Get mail by ID
   - GET `/api/mail` - Get all mail
   - POST `/api/mail` - Create new mail
   - PUT `/api/mail/{id}` - Update mail
   - DELETE `/api/mail/{id}` - Delete mail by ID


Example POST request body (app_user):

```json
{
  "username": "bertusmaximus",
  "email": "drbert@conke.ru",
  "password": "hemmelig"
}
```

## Project Structure

```
src/main/java/org/example/mailserver
├── config/          # Configuration classes
├── controller/      # REST controllers
├── model/           # Entity classes
├── repository/      # Data access layer
├── service/         # Business logic
├── dto/             # Data Transfer Objects
├── mapper/          # Object mappers
└── exception/       # Exception handling
```

## Key Components

### Entity
The `Mail` entity represents a mail in the database with fields:
- id (primary key)
- subject
- fromEmail
- toEmail
- content
- timestamp

### Repository
The `MailRepository` provides data access methods:
- Basic CRUD operations (from JpaRepository)
- Custom finder methods

### Service
The `MailService` implements business logic:
- Get mail by ID
- Get all mail 
- Create new mail
- Update existing mail
- Delete mail

### Controller
The `MailController` defines REST endpoints:
- GET `/api/mail/{id}` - Get mail by ID
- GET `/api/mail` - Get all mail
- POST `/api/mail` - Create new mail
- PUT `/api/mail/{id}` - Update mail
- DELETE `/api/mail/{id}` - Delete mail by ID
