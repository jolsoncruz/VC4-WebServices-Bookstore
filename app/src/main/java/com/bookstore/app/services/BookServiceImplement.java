package com.bookstore.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.entities.Book;
import com.bookstore.app.repositories.BookRepository;

@Service
public class BookServiceImplement implements BookService{

    @Autowired
    private BookRepository br;

    // Create
    @Override
    public Book save(Book b) {
        return br.save(b);
    }

    // Read
    @Override
    public Optional<Book> findById(Long id) {
        return br.findById(id);
    }

    // Delete
    @Override
    public void delete(Long id) {
        br.deleteById(id);
    }
    
}
