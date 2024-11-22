package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repo.AuthorRepository;
import com.example.bookstore.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

//    public List<Book> searchBooks(String keyword) {
//        if (keyword == null || keyword.trim().isEmpty()) {
//            return bookRepository.findAll();
//        }
//        return bookRepository.findBookByTitle(keyword.trim());
//    }

    //2
    /*public List<Book> search(String title) {
        if(title == null || title.trim().equals("")){
            return bookRepository.findAll();
        }
            return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    */




    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorByName(String author) {
        return authorRepository.findByName(author);
    }

//3
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

//3
    public List<Book> getByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }



    public List<Book> getAllBookDto(BookDto bookDto){
        return bookRepository.findAll();
    }

    public Book getBookById(long id){
        return bookRepository.findById(id).get();
    }

    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBookByDto(long id){
        return bookRepository.findById(id).get();

    }

    public void deleteBookById(long id){
        bookRepository.deleteById(id);
    }



}
