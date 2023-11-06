package com.bookstore.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    
    @Id
    @GeneratedValue
    private Long bookId;
    private String author;
    private String title;
    private String genre;
    private double price;
    private int publishYear;

    // Getters
    public Long getBookId() {
        return bookId;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public double getPrice() {
        return price;
    }
    public int getPublishYear() {
        return publishYear;
    }

    // Setters
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    // ToString
    @Override
    public String toString() {
        return "Book [title=" + title + "]";
    }
}
