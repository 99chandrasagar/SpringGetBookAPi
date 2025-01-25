//SPRING BOOT FLOW ARCHITECTURE
//postman client request -->  controllers(api layer)  --> Services(Business Logic)  --> Models(Data Representation)
//vice versa reverse 

package com.example.goodreads;

import java.util.*;
import com.example.goodreads.Book;
import com.example.goodreads.BookRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookService implements BookRepository {
    // In order to store the book objects let's use hashmap with the bookid as key
    // and import util and Book is class impported
    private HashMap<Integer, Book> hmap = new HashMap<>();

    // lets add a constructor and create some sample books data
    public BookService() {
        Book b1 = new Book(1, "harry potter", "harry_potter.jpg");
        Book b2 = new Book(2, "Rise", "rise.jpeg");
        // keeping book ids as keys in the HashMap to store book objects
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    // In java @override annotation is used to indicate that method is intended to
    // override a method in a superclass.
    // it helps ensure the correct method is being overridden and improves code
    // clarity
    @Override
    public ArrayList<Book> getBooks() {
        // the HashMap method values() returns a list of objects of Collection<Object>
        // data type
        // Collection<E> it is interface (extends) --> List<E> it is interface
        // (implements) --> ArrayList<E> it is interface (class)
        Collection<Book> bookCollection = hmap.values();
        // converting collection to arraylist type
        ArrayList<Book> books = new ArrayList<>(bookCollection);
        return books;
        // lets use BookService getBooks() method to return books data from the
        // BookController
    }

    @Override
    public Book getBookbyId(int bookId) {
        Book book = hmap.get(bookId);
        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }
}