Week 1: Participation Assignment
Student: Jose Ruiz

Website Tested:
- https://www.saucedemo.com

Tests Included:

	Driver Factory:
	- Responsible for creating and managing the WebDriver instance
	- Centralizes browser setup and configuration
	- Prevents duplicated driver initialization across tests

	Wait Utility:
	- Provides reusable explicit wait methods using WebDriverWait
	- Improves test reliability by avoiding the use of Thread.sleep
	- Includes methods for waiting for the element clickability fixing the issue of 	menu related tests in Product Page

	Login Tests:
	- Verify login page loads correctly by checking page title, username and password 	field, and login button
	- Verify successful login with valid credentials
	- Verify invalid login shows an appropriate error message

	Products Page Tests:
	- Verify products page loads correctly by checking page title, cart icon and menu 	with the options available (Logout and Reset App State)
	- Verify navigation through menu options (All Items and Logout)
	- Verify a user can add a product to the cart and that the product is correctly
  	reflected in the cart

How to Run the Tests:
Open the project in IntelliJ IDEA
Run tests using one of the following methods:
- Maven Tool Window → Lifecycle → clean → test
- IntelliJ Terminal: mvn clean test
Confirm all tests pass with BUILD SUCCESS

Special Setup Requirements:
- Google Chrome browser installed
- Project Set Up with JDK 23.0.1

Week 2: Participation Assignment

API Used:
- JSONPlaceholder (https://jsonplaceholder.typicode.com)

Endpoints Tested:
- GET /users
- GET /users/{id}
- GET /posts
- GET /posts/{id}
- POST /posts
- PUT /posts/{id}
- DELETE /posts/{id}
- GET /comments
- GET /comments/{post-id}

How to Run with Newman:
newman run api-tests.json -e dev-environment.json

How to Run with Maven:
Open the project in IntelliJ IDEA
Run tests using one of the following methods:
- Maven Tool Window → Lifecycle → clean → test
- IntelliJ Terminal: mvn clean test
Confirm all tests pass with BUILD SUCCESS

mvn clean test