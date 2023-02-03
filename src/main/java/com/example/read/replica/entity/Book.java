package com.example.read.replica.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shubhamkumar
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

  @Id
  private Long id;

  private String name;

  private String author;

}
