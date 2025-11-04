package com.example.bookstore.repo;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//2
//    @Query(value = "select * from book b where b.title like %:title%", nativeQuery = true)
//    List<Book> findByTitleContainingIgnoreCase(@Param("title")String title);

    //1
    //@Query(value = "SELECT * FROM BOOK WHERE TITLE = ?1", nativeQuery = true)
//    List<Book> findByTitle( String title);

    //3
//    @Query(value = "SELECT * FROM book b WHERE b.title LIKE %:title% ",
//            nativeQuery = true)


        //@Query("select b from Book b where b.title = ?1")
    List<Book> findByTitleContainingIgnoreCase(String title);
}
