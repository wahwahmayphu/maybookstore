package com.example.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "myBooks")
public class BookList {

    @Id
    private Long id;
    private String title;
    private String author;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    public BookList(String title, Author author, double price, LocalDate publicationDate) {
        this.title = title;
        this.author = String.valueOf(author);
        this.price = price;
        this.publicationDate = publicationDate;
    }
}
