package com.example.springbootredis.controller;

import com.example.springbootredis.entity.Book;
import com.example.springbootredis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get/{id}")
    public Book findOne(@PathVariable Long id){
        if(bookRepository.findById(id) == null){
            return null;
        }
        return bookRepository.findById(id);

    }

    @PostMapping("/create")
    public String newBook(@RequestBody Book newBook) {
        bookRepository.save(newBook);
        return "Added: ".concat(newBook.getName());
    }
}
