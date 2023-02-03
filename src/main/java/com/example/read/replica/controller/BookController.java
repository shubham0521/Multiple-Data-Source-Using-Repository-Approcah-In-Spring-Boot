package com.example.read.replica.controller;

import java.util.List;

import com.example.read.replica.dao.BookDao;
import com.example.read.replica.entity.Book;
import com.example.read.replica.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shubhamkumar
 */

@RestController
@RequestMapping("/api/v1")
public class BookController {

  @Autowired
  private BooksService service;

  @GetMapping("/getAllBooks")
  public List<Book> getAllEmployees() {
    return service.getAllBooks();
  }

  @PostMapping("/addBooks")
  public Book addBooks(@RequestBody BookDao book){
    return service.
      addBooks(book);
  }

  @PostMapping("/updateBooks")
  public Book updateBooks(@RequestBody BookDao book){
    return service.updateBooks(book);
  }


}
