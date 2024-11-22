Bookstore Application
This is a Spring Boot application for managing a bookstore. It provides functionality to add, edit, delete, and search for books, as well as display available books.

Features
Home Page           : A simple homepage for the application.
Book Registration   : Add new books with validation.
Book Listing        : View all available books in the store.
Edit Books          : Update the details of an existing book.
Delete Books        : Remove a book from the database.
Search Functionality: Search for books by title.

Technology Stack
Java              : Core programming language.
Spring Boot       : Framework for building the application.
Thymeleaf         : Template engine for rendering views.
Jakarta Validation: For input validation.
Lombok            : To reduce boilerplate code (e.g., @RequiredArgsConstructor).
Spring MVC        : For handling HTTP requests and responses.

Setup Instructions
Prerequisites
- Java 17 or higher
- Maven for dependency management
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Database (e.g., H2, MySQL, or PostgreSQL)

Steps to Run
1.Clone the Repository:
  git clone <repository_url>
  cd bookstore

2.Build the Project:
  mvn clean install
  
3.Run the Application:
  mvn spring-boot:run
  
4.Access the Application: 
  Open a browser and navigate to http://localhost:8080.

Endpoints
Web Endpoints
  /                    : Home page.
  /book_register       : Page to register a new book.
  /save                : Save a new or updated book.
  /available_books     : List all available books.
  /edit/{id}           : Edit an existing book by its ID.
  /deleteBook/{id}     : Delete a book by its ID.
  /search?title=<title>: Search for books by title.
