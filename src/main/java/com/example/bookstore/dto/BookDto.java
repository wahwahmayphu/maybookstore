package com.example.bookstore.dto;


import com.example.bookstore.entity.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    @NotEmpty(message = "Title is required")
    private String title;


    private String author; // to change author

    @NotNull(message = "Price is required")
    private double price;

    @NotNull(message = "Date is required")
    private LocalDate publicationDate;

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' + // to chage author
                ", price=" + price +
                ", publicationDate=" + publicationDate +
                '}';
    }

    public void setAuthor(String author) { // to change author
        this.author = author;// to change author
    }
}
