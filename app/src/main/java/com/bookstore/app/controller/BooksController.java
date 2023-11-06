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

import com.bookstore.app.entities.Book;
import com.bookstore.app.services.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {
    
    @Autowired
    private BookService bs;

    @PostMapping("/save")
    public Response save(@RequestBody Book b){
        Response res = new Response();

        try{
            bs.save(b);
            res.setResult(b.toString() + " added.");
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
            res.setResult(bs.findById(id).get().toString() + " found.");
            res.setStatus("Success");
            return res;
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("Fail");
            return res;
        }
    }

    @PutMapping("/update")
    public Response update(@RequestBody Book b){
        Response res = new Response();

        try{
            Book found = bs.findById(b.getBookId()).get();
            res.setResult(found.toString() + " updated.");
            bs.save(b);
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
            Book b = bs.findById(id).get();
            res.setResult(b.toString() + " deleted.");
            bs.delete(b.getBookId());
            res.setStatus("Success");
            return res;
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("Fail");
            return res;
        }
    }
}
