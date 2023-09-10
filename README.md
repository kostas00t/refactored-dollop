# Product Management System

## Functionality

* ❌User Registration and Login: Implement secure registration (username, email, password) and login features.
* ✅Role-Based Authorization: Define roles for users and administrators. Users view/add products, administrators update/delete.
* ✅Product Management Endpoints: Design REST endpoints for product operations (add, update, retrieve) including attributes (name, description, price).
* ✅Security: Ensure robust security mechanisms to prevent unauthorized access.
* ❌Bonus: Testing: Include unit tests to ensure functionality and security.
* ✅Bonus: Endpoint Documentation: Document the REST endpoints for ease of use.

## Tech Stack used

* Spring Boot (2.7.15) for implementation 
* PostgreSQL (15.4) for data storage
* Postman (10.17.4) for API interaction

## Running instructions

* Import the project into an IDE (Eclipce, IntelliJ IDEA, etc).
* Configure *application.properties* file to connect to a postgreSQL database.
* Run the *sqlscript.sql* to create the products table and populate the database (file in pms\src\main\resources).
* Run as Spring Boot App / Java Application.
* Interaction with the REST API via Postman.

API documentation can be found at the *documentation.pdf*

