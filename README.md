# Diary

A web-application where you can write, read, and edit diary posts/entries.
The posts are saved in a MySQL DB.


## Features
- Create/write post, edit and delete with CRUD operations.
- Every post has a title, text and date.
- Ability to create posts back in time but also for the future.
- Posts with a future date isnt shown until that date is current or passed.
- Ability to filter posts between two dates chosen by the user.
- Some input validation and error handling.
## Technical Overview

- **Spring Boot** as the backend framework
- **Spring Boot JPA** for database access
- **Thymeleaf** for server-side template rendering
- **HTML**, **CSS**, and **JavaScript** for the frontend
- **MySQL** as the database

## Running the Project

1. Clone the repository or download it as a zip  
2. Open it in any Java IDE (e.g. VSC, IntelliJ)  
3. Let Maven download all dependencies  
4. Start the application by running:  
   `mvn spring-boot:run`  
   or by running the **Application** class directly from the IDE  
5. Open your browser and go to:  
   `http://localhost:8080`


## Challenge

A challenge in this project was to understand and implement the service class that "speaks" between the controller and the repository. At first, I put all the logic in the controller, requesting query methods from the repoistory directly, but after reading guides such as (https://anilr9.medium.com/understanding-service-in-spring-boot-a-complete-guide-with-examples-b08825e8ccd8) and experimenting, I learned to move the logic into a separate service class.

Other than that, I had some trouble filtering posts, but after reading the documentation on query methods (https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html) and experimenting with different ones, i managed to implement a few solutions. In the end, I was able to filter posts between two dates and make so that future posts are not shown until the current date has been reached or passed.

Extra note: I also had some huge issues with corrupted database tables when using MAMP—after exiting the project and turning Apache and MySQL off and starting it up again, nothing worked. I tried XAMPP and the same problem occurred, and I couldn't find any solution to what was causing it. At last, I found and tested Laragon as my local development environment, and so far it has worked without problems.

## Author
- **@Kippzta** (Erik Rehnberg)

