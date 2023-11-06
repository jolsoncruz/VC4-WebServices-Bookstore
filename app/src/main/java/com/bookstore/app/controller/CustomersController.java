package com.bookstore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.entities.Customer;
import com.bookstore.app.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    
    @Autowired
    private CustomerService cs;

    @PostMapping("/save")
    public Response save(@RequestBody Customer c){
        Response res = new Response();

        try{
            cs.save(c);
            res.setResult(c.toString() + " added.");
            res.setStatus("Success");
            return res;
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("Fail");
            return res;
        }
    }

    @GetMapping("/find")
    public Response findById(@RequestParam Long id ){
        Response res = new Response();

        try{
            res.setResult(cs.findById(id).get().toString() + " found.");
            res.setStatus("Success");
            return res;
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("Fail");
            return res;
        }
    }

    @PutMapping("/update")
    public Response update(@RequestBody Customer c){
        Response res = new Response();

        try{
            Customer found = cs.findById(c.getCustomerId()).get();
            res.setResult(found.toString() + " updated.");
            cs.save(c);
            res.setStatus("Success");
            return res;
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("Fail");
            return res;
        }
    }

    @DeleteMapping("/delete")
    public Response delete(@RequestParam Long id){
        Response res = new Response();

        try{
            Customer c = cs.findById(id).get();
            res.setResult(c.toString() + " deleted.");
            cs.delete(c.getCustomerId());
            res.setStatus("Success");
            return res;
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("Fail");
            return res;
        }
    }
}
