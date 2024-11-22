package com.example.bookstore;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repo.AuthorRepository;
import com.example.bookstore.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class BookstoreApplication {

	@Autowired
	private final BookRepository bookRepository;

//	@Bean @Transactional
//	public ApplicationRunner runner(AuthorRepository authorRepository){
//		return args -> {
//			Author author1 = new Author("Mya Than Tint");
//			Author author2 = new Author("Khin Khin Htoo");
//			Book book1 = new Book("Across the Mountain of Swords and the Sea of Fire",8000.0, LocalDate.of(1973,04,11));
//			Book book2 = new Book(" Gone with the Wind",9000.0, LocalDate.of(1978,10,20));
//			Book book3 = new Book("Ma Eain Kan",9000.0, LocalDate.of(2007,06,05));
//			Book book4 = new Book("Taw Minthamee",9000.0, LocalDate.of(2014,12,05));
//
//			author1.addBook(book1);
//			author1.addBook(book2);
//			author2.addBook(book3);
//			author2.addBook(book4);
//
//			authorRepository.save(author1);
//			authorRepository.save(author2);
//		};
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
