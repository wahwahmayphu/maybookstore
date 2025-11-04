package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookListService;
import com.example.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @Autowired
    private final BookListService bookListService;

    private static List<String> author;
        static {
            author = new ArrayList<>();
            author.add("Mya Than Tint");
            author.add("Khin Khin Htoo");
        }


    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/book_register")
    public String bookRegister(Model model){
        System.out.println("Author name : "+bookService.getAllAuthors());
        model.addAttribute("book",new Book());
        model.addAttribute("authors",bookService.getAllAuthors());
        return "bookRegister";
    }

    @PostMapping("/save")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){// to change book to BookDto
            if(bindingResult.hasErrors()){
                return "bookRegister";
            }
            System.out.println("Result : " + book);
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message" ,book.getId() > 1 ? "Updated Successfully" : "Created Successfully");
        return "redirect:/available_books";
    }

    @GetMapping("/available_books")
    public ModelAndView getAvailableBooks(){
        List<Book> list = bookService.getAllBooks();
        System.out.println("Book List "+list);
        return new ModelAndView("bookList","bookList",list);

    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
            Book book = bookService.getBookById(id);
            System.out.println("GetById : " + book );
            model.addAttribute("book", book);
            model.addAttribute("authors",bookService.getAllAuthors());
            return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id,Model model,RedirectAttributes redirectAttributes){
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("message","Deleted Successfully");
        return "redirect:/available_books";

    }

    @RequestMapping("/search")
    public String search(@Param("title") String title, Book book, Model model) {
        if (title != null) {
            List<Book> list = bookService.getByTitle(title);
            model.addAttribute("bookList", list);
        } else {
            List<Book> list = bookService.getAllBooks();
            model.addAttribute("bookList", list);
        }
        model.addAttribute("title",title);
        return "bookList";
    }

}
