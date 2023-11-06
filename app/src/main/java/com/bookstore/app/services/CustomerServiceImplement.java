package com.bookstore.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.entities.Customer;
import com.bookstore.app.repositories.CustomerRepository;

@Service
public class CustomerServiceImplement implements CustomerService {

    @Autowired
    private CustomerRepository cr;

    // Create
    @Override
    public Customer save(Customer c) {
        return cr.save(c);
    }

    // Read
    @Override
    public Optional<Customer> findById(Long id) {
        return cr.findById(id);
    }

    // Delete
    @Override
    public void delete(Long id) {
        cr.deleteById(id);
    }
}
