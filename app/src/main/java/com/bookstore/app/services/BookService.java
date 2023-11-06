package com.bookstore.app.services;

import java.util.Optional;
import com.bookstore.app.entities.Book;

public interface BookService {
    Book save(Book b);

    Optional<Book> findById(Long id);
    void delete(Long id);
}
