package com.bookstore.app.services;

import java.util.Optional;
import com.bookstore.app.entities.Customer;

public interface CustomerService {
    Customer save(Customer c);

    Optional<Customer> findById(Long id);
    void delete(Long id);
}
