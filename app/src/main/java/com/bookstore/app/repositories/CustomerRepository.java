package com.bookstore.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Long> {
    
}
