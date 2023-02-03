package com.example.read.replica.repository.write;

import com.example.read.replica.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shubhamkumar
 */
public interface SecondaryRepository extends JpaRepository<Book, Long> {
}
