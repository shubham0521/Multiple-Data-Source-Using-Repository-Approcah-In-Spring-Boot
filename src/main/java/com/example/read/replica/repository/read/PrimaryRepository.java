package com.example.read.replica.repository.read;

import com.example.read.replica.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shubhamkumar
 */
public interface PrimaryRepository extends JpaRepository<Book, Long> {
}
