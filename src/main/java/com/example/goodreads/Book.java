//Book class is respoonsible for creating a book objects

package com.example.goodreads;

//lets create a  Book class name should be same as file name
public class Book {
    private int id;
    private String name;
    private String imageUrl;

    // lets add a constructor to intialize a class
    public Book(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    // lets add getter and setter for setting and retrieving id attribute
    // value,name,imageurl
    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    // passing name to set
    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}