package com.example.read.replica.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.read.replica.dao.BookDao;
import com.example.read.replica.entity.Book;
import com.example.read.replica.repository.read.PrimaryRepository;
import com.example.read.replica.repository.write.SecondaryRepository;
import com.example.read.replica.service.BooksService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shubhamkumar
 */
@Service
public class BookServiceImpl implements BooksService {

  @Autowired
  private PrimaryRepository primaryRepository;

  @Autowired
  private SecondaryRepository secondaryRepository;

  @Override
  public Book addBooks(BookDao request) {
    Book book = Book.builder()
      .id(request.getId())
      .author(request.getAuthor())
      .name(request.getName())
      .build();
    return primaryRepository.save(book);
  }

  @Override
  public Book updateBooks(BookDao request) {
    Book bookFetchedFromDB = Optional.of(primaryRepository.findById(request.getId())).map(Optional::get).orElseThrow();
    bookFetchedFromDB.setAuthor(request.getAuthor());
    primaryRepository.save(bookFetchedFromDB);
    return Optional.ofNullable(primaryRepository.findById(request.getId())).orElseThrow().get();
  }

  @Override
  public List<Book> getAllBooks() {
    return secondaryRepository.findAll();
  }
}
