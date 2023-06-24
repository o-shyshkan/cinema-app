#**cinema-app**
cinema-app it is application with REST API designed to manage tickets in cinema business.
Application has REST API, registration/authentication/role authorizations,
basic CRUD operations and use as storage MySQL database.

##**Features**:
1. Registration/Authentication as user;
2. Create/Get/GetAll for CinemaHall;
3. Create/Get/GetAll for Movie;
4. Create/Get/FindByEmail for User;
5. Create/GetByName for Role;
6. Create/Get/Update/Delete/FindAvailableSessions(by movieId and date) for MovieSessions;
7. Create/Delete/GetByUser/Add MovieSession to ShoppingCart;
8. Create Ticket;
9. Create/getOrdersHistory(by User) for Order;
10. Two roles USER and ADMIN;
11. Injecting initial data;
12. Get and sent information in JSON format;

##**Structure:**
* cinema-app - root directory for project;
* config - configuration and security files for Spring Framework
* controller - package for Spring controllers where defined end point ;
* dao - package for DAO interface for MySQL database;
* dto - package for data transfer models in separate folder for request and response; 
* exception - package for exceptions;
* lib - package for validation email and password;
* model - package for entity models: User, Ticket, Role, ShopingCart, Order, MovieSession, Movie, CinemaHall;
* service - package for service and mapper interfaces;
* util - package for date pattern;
* resources - package for credential to database and Hibernate properties;


##**Technology:**
1. Java - JDK 18
2. Web server - Tomcat 9.0.58
3. Database - MySQL 8.0.32
4. Driver for DB - mysql-connector-java 8.0.32
5. Spring framework - 5.3.20
6. Hibernate - 5.6.14.Final

##**Getting started:**
1. Make new directory for cinema-app application, for example cinema-app
2. In command line clone code from repository to cinema-app directory
   ```git@github.com:o-shyshkan/cinema-app.git```
3. Open cinema-app project in your favorite IDE
4. In pom.xml file check actual version of these library:
    + mysql-connector-java 8.0.32 or higher
    + javax.servlet-api 4.0.1 or higher
    + springframework 5.3.20 or higher
    + spring.security 5.6.10or higher
    + hibernate 5.6.14.Final or higher
    + jdk.version 18 or higher
5. Set up connection to your MySQL database in file [db.properties](src/main/resources/db.properties)
   ```public class ConnectionUtil {
   db.url=jdbc:mysql://localhost:3306/cinema?serverTimezone=UTC
   db.user=USER_NAME
   db.password=USER_PASSWORD
6. Check that pom.xml has this line <packaging>war</packaging>   
7. In menu Run-Edit Configuration set up Run Configuration for Tomcat
   You need Tomcat version 9.0.58 or higher
   add artifacts taxi-service:war exploded
   check that this artifact will be in deploy at the server start up
8. Run program
9. Type in browser url http://localhost:8080/inject to inject initial users
   With role ADMIN - user_name: admin@gmail.com user_password: 1234
   With role USER - user_name: bob32@gmail.com user_password: 1234
10. Make authentication on page http://localhost:8080/login with login and password above
12. To get all movies type url http://localhost:8080//movies
13. There are 15 endpoint available that show below 

14. ##**Description REST API of cinema-app:**
1. Register new user
    POST http://localhost:8080/register
    Authorization: Basic user passwd
    Content-Type: application/json
   {
   "email": "bob33@gmail.com",
   "password": "1234",
   "repeatPassword": "1234"
   }
   Response:
   {
   "id":1,
   "email": "bob33@gmail.com"
   }
2. Movie
   add new Movie
   POST http://localhost:8080/movies
   Authorization: Basic user passwd
   Content-Type: application/json
   {
   "title": "Terminator 1",
   "description": "Action movie"
   }
   Response:
   {
   "id": 1,
   "title": "Terminator 1",
   "description": "Action movie"
   }
   get all movies
   GET http://localhost:8080/movies
   Response:
   {
   "id": 1,
   "title": "Terminator 1",
   "description": "Action movie"
   }
3. Cinema Hall
      add new Cinema Hall
      POST http://localhost:8080/cinema-halls
      Authorization: Basic user passwd
      Content-Type: application/json
      {
      "capacity": 100,
      "description": "Yellow hall"
      }
      Response:
      {
      "id": 1,
      "capacity": 100,
      "description": "Yellow hall"
      }   
4. Get all Cinema Hall 
      GET http://localhost:8080/cinema-halls
      Response: 
      {
      "id": 1,
      "capacity": 100,
      "description": "Yellow hall"
      }
4. Movie Session
   add new Movie Session
   POST http://localhost:8080/movie-session
   Authorization: Basic user passwd
   Content-Type: application/json
   {
   "movieId": 1,
   "cinemaHallId": 1
   "showTime": "dd.MM.yyyy"
   }
  Response:
   {
   "movieSessionId": 1,
   "movieId": 1,
   "movieTitle": "Terminator 1",
   "cinemaHallId": 1
   "showTime": "dd.MM.yyyy"
   }
   Get available movie session by movie id and date
   GET http://localhost:8080/movie-session/available?movieId=1&date='dd.MM.yyyy'
   {[{
5. "movieSessionId": 1,
   "movieId": 1,
   "movieTitle": "Terminator 1",
   "cinemaHallId": 1
   "showTime": "dd.MM.yyyy"
   }]}
   Update Movie Session by Id
   PUT http://localhost:8080/movie-session/{id}
   Authorization: Basic user passwd
   Content-Type: application/json
   {
   "movieId": 1,
   "cinemaHallId": 1
   "showTime": "dd.MM.yyyy"
   }
   Delete Movie Session by Id
   DELETE http://localhost:8080/movie-session/{id}
   Authorization: Basic user passwd
5. Shoping Cart
   Add Movie session to the Shoping cart by movieSessionId
   PUT http://localhost:8080/shopping-carts/movie-sessions&movieSessionId=1
   Authorization: Basic user passwd
   Get shoping cart by userId
   GET http://localhost:8080/shopping-carts/by-user
   Authorization: Basic user passwd
6. Order
   Order complete by user
   POST http://localhost:8080/orders/complete
   Authorization: Basic user passwd
   Response:
  {
   "id":1,
   "ticketIds":[1,2,3],
   "userId":1,
   "orderTime":"LocalDateTime"
   }
   Get all orders by user
   GET http://localhost:8080/orders
   Authorization: Basic user passwd
   Response:
   {
   "id":1,
   "ticketIds":[1,2,3],
   "userId":1,
   "orderTime":"LocalDateTime"
   }
## Links: ##
- [Home](https://github.com/o-shyshkan/cinema-app/edit/main/README.md#cinema-app-oncoming_taxi)
- [Features](https://github.com/o-shyshkan/cinema-app/edit/main/README.md#features)
- [Structure](https://github.com/o-shyshkan/cinema-app/edit/main/README.md#structure)
- [Technology](https://github.com/o-shyshkan/cinema-app/edit/main/README.md#technology)
- [Getting-started](https://github.com/o-shyshkan/cinema-app/edit/main/README.md#getting-started)
