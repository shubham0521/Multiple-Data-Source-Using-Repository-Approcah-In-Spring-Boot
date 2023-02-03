package com.example.read.replica.service;

import java.util.List;

import com.example.read.replica.dao.BookDao;
import com.example.read.replica.entity.Book;

/**
 * @author shubhamkumar
 */
public interface BooksService {

  public Book addBooks(BookDao request);

  public List<Book> getAllBooks();

  public Book updateBooks(BookDao request);
}
