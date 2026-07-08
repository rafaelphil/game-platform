# Game Platform

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Authentication-blue)
![License](https://img.shields.io/badge/license-MIT-blue)

A RESTful game platform API built with Java and Spring Boot. This application allows users to create accounts, publish games, post reviews for games, and add games to their libraries.

## Features
Users are able to:
- Register an account, login to an existing account, and delete an account
- Publish games and delete published games from your account
- Add games to their libraries and remove games from their libraries
- Post reviews for games they have in their accounts and update existing reviews

## Technologies Used
- Java 25
- Spring Boot
- PostgreSQL
- Hibernate
- Maven
- Spring Security
- JWT
- Swagger

## Architecture
### Database
This application models relational data between entities, which makes PostgreSQL a good choice for the database
<img width="1068" height="729" alt="Screenshot 2026-07-08 at 10-57-21 Draw DrawSQL" src="https://github.com/user-attachments/assets/a1a19391-39d6-4cb6-877e-56c87d240199" />
The application features a relational database consisting of four entities:

- User
- Game
- Library
- Review

Relations: 
- **User - Game**: A user can have multiple games published, but a game belongs only to one user (1-M)
- **User - Review**: A user can post multiple reviews, but a review belongs only to one user (1-M)
- **User - Library**: A user can have multiple games in their library, but a library entry belongs only to one user (1-M)
- **Game - Review**: A game can have multiple reviews, but a review describes only one game (1-M)
- **Game - Library**: A game can belong to many library entries, but a library entry can only contain one game (1-M)

Constraints:
- Usernames must be unique
- A user cannot publish two games with the same title
- A user cannot have the same game multiple times in their library
- A user can post only one review per game
- Game ratings must range from 0 to 10

### Exceptions
Applicaiton errors are handled using a *Global Exception Handler* with custom Exceptions

### Security
Authentication is implemented using JSON Web Tokens (JWT) and passwords are hashed securely using the BCrypt library. Endpoints require a valid JWT to access


## How To Run The Application
1. Clone the project with `git clone {url}`
2. Configure the following environment variables:
   - DB_URL
   - DB_USER
   - DB_PASSWORD
   - JWT_KEY
   - JWT_EXPIRATION
3. Start the application with `./mvnw spring-boot:run`
4. Head to http://localhost:8080/swagger-ui/index.html to test the API

<img width="1460" height="709" alt="Screenshot 2026-07-08 at 12-37-19 Swagger UI" src="https://github.com/user-attachments/assets/9ae98801-b6fe-4df5-b7e1-9649f14505fd" />
<img width="1460" height="595" alt="Screenshot 2026-07-08 at 12-37-10 Swagger UI" src="https://github.com/user-attachments/assets/b7ce72a6-1989-4c85-9bee-127d96e5f1c2" />
