package com.example.read.replica.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shubhamkumar
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDao {
  private Long id;

  private String name;

  private String author;
}
