package com.bookstore.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    
}
