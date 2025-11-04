package com.example.bookstore.service;

import com.example.bookstore.entity.BookList;
import com.example.bookstore.repo.BookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookListService {
    @Autowired
    private BookListRepository bookListRepository;
    public void save(BookList bookList) {
        bookListRepository.save(bookList);
    }
    public List<BookList> getAllBookList() {
        return bookListRepository.findAll();
    }
}
