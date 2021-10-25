package com.example.democassandra.controller;

import com.example.democassandra.entity.Book;
import com.example.democassandra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.BasicMapId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getbook")
    public List<Book> getBook(){
      return  bookRepository.findAll();
    }

    @GetMapping("/getbookbyid")
    public Book getBookById(@RequestParam String title ,@RequestParam String publisher,@RequestParam String isbn){
      return  bookRepository.findById(BasicMapId.id("isbn",isbn).with("title",title).with("publisher",publisher)).get();
    }

    @PostMapping("/savebook")
    public boolean saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return true;
    }
}
