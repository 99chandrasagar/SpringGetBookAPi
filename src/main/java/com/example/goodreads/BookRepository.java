//SPRING BOOT FLOW ARCHITECTURE
//postman client request -->  controllers(api layer)  --> Repository(Interface/classes) --> Services(Business Logic)  --> Models(Data Representation)
//vice versa reverse 

//let's write some methods in the BookService class for managing Books data
//we are currently writing BookService in order to provide some temporary data
//Later we will write different services for different databses to change only the business logic for managing books
//let create a interface for consistency and abstraction across the services
//the interface will provide standardized methods for managing books in the service classes to implement
package com.example.goodreads;

import java.util.ArrayList;
import com.example.goodreads.Book;

//simillary how classname and file name should same for interface also same
public interface BookRepository {
    ArrayList<Book> getBooks();

    Book getBookbyId(int bookId);
}