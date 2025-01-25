# GetBooks API

This project demonstrates how to build a simple REST API using Spring Boot that serves a list of books without using a database. The data is hardcoded into the application for simplicity.

## Features
- RESTful API endpoint to retrieve a list of books or a specific book by its ID.
- Data served directly from an in-memory list.
- Lightweight and easy-to-understand implementation.

## Prerequisites
Before running the application, ensure you have the following installed:

- Java 8 or later
- Maven or Gradle
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code (optional but recommended)

## Steps to Create the API

### 1. Project Setup
1. Create a new Spring Boot project.
   - You can use [Spring Initializr](https://start.spring.io/).
   - Add the following dependencies:
     - Spring Web

2. Import the project into your IDE.

### 2. Create the `Book` Model
Create a class `Book` in the `model` package:

```java
package com.example.getbooks.model;

public class Book {
    private int id;
    private String name;
    private String imageUrl;

    // Constructors
    public Book(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
```

### 3. Create the `BookController`
Create a REST controller to expose the API endpoints:

```java
package com.example.getbooks.controller;

import com.example.getbooks.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final List<Book> books = Arrays.asList(
            new Book(1, "harry potter", "harry_potter.jpg"),
            new Book(2, "Rise", "rise.jpeg")
    );

    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == bookId).findFirst();
        return book.orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
```

### 4. Run the Application
1. Run the `main` method in the `GetBooksApplication` class (created by Spring Boot).
2. The application will start on the default port (8080).

### 5. Test the API
- Use Postman, curl, or your browser to test the API.
- Retrieve all books:
  - GET request to: `http://localhost:8080/books`
- Retrieve a specific book by ID:
  - GET request to: `http://localhost:8080/books/{bookId}` (replace `{bookId}` with the desired book ID)

#### Example Response for `/books`:
```json
[
  {
    "id": 1,
    "name": "harry potter",
    "imageUrl": "harry_potter.jpg"
  },
  {
    "id": 2,
    "name": "Rise",
    "imageUrl": "rise.jpeg"
  }
]
```

#### Example Response for `/books/1`:
```json
{
  "id": 1,
  "name": "harry potter",
  "imageUrl": "harry_potter.jpg"
}
```

## Dependencies
This project uses the following dependencies:
- Spring Boot Starter Web

