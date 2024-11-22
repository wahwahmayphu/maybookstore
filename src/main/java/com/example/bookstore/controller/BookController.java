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
            //Book book = new Book(); // to close

        //BookDto bookDto = new BookDto(); //to reopen
        //model.addAttribute("author", author);
        //model.addAttribute("bookDto",bookDto);// to reopen
       // model.addAttribute("book",book); // to close
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


//        System.out.println("Result  : "+bookDto);
//        Book book = new Book();
//        Author author =  bookService.getAuthorByName(bookDto.getAuthor());// to change getAuthor
//        System.out.println("author  : "+author);

//        book.setId(bookDto.getId());
//        book.setTitle(bookDto.getTitle());
//        book.setAuthor(author);
//        book.setPrice(bookDto.getPrice());
//        book.setPublicationDate(bookDto.getPublicationDate());

//        Author author =  bookService.getAuthorByName(String.valueOf(book.getAuthor()));
//
//        book.setId(book.getId());
//        book.setTitle(book.getTitle());
//        book.setAuthor(author);
//        book.setPrice(book.getPrice());
//        book.setPublicationDate(book.getPublicationDate());


       // System.out.println("Book form : " + book);

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



//    @RequestMapping("/myBookList/{id}")
//    public String getBookList(@PathVariable("id") Long id){
//        Book bookName = bookService.getBookById(id);
//        BookList bookList = new BookList(bookName.getTitle(),bookName.getAuthor(),bookName.getPrice(),bookName.getPublicationDate());
//        bookListService.save(bookList);
//        return "redirect:/my_book" ;
//    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){


            Book book = bookService.getBookById(id);
            System.out.println("GetById : " + book );
            model.addAttribute("book", book);
            model.addAttribute("authors",bookService.getAllAuthors());
//            bookService.saveBook(book);
//            redirectAttributes.addFlashAttribute("message","Updated Successfully");
            return "bookEdit";
    }


    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id,Model model,RedirectAttributes redirectAttributes){
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("message","Deleted Successfully");
        return "redirect:/available_books";

    }

    //search 2

//    @GetMapping("/search")
//    public String getBooks(@Param("title") String title,Model model){
//
//
//      /*  if(title !=null){
//            model.addAttribute("books",bookService.search(title));
//        }else{
//            model.addAttribute("books",bookService.getAllBooks());
//        }*/
//
//        //List<Book> books = new ArrayList<>();
////        System.out.println(books);
//        List<Book>  books = bookService.search(title);
//            model.addAttribute("bookList",books);
//            model.addAttribute("title",title);
//             System.out.println("Search bookList "+ books);
//            return "bookList";
//    }


    //search 3
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






//    @GetMapping("/tutorials")
//    public String getAll(Model model, @Param("keyword") String keyword) {
//        try {
//            List<Tutorial> tutorials = new ArrayList<Tutorial>();
//
//            if (keyword == null) {
//                tutorialRepository.findAll().forEach(tutorials::add);
//            } else {
//                tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
//                model.addAttribute("keyword", keyword);
//            }
//
//            model.addAttribute("tutorials", tutorials);
//        } catch (Exception e) {
//            model.addAttribute("message", e.getMessage());
//        }
//
//        return "tutorials";
//    }

    //For search
//    @GetMapping("/available_books")
//    public String searchBook(Model model, @Param("keyword") String keyword){
//           List<Book> books = bookService.findAllBooks(keyword);
//           model.addAttribute("books", books);
//           model.addAttribute("keyword", keyword);
//           return "bookList";
//
//    }

    /*@RequestMapping("/search")
    public String home(@Param("keyword") String keyword, Model model,Book book) {
        if (keyword != null) {
            List<Book> list = bookService.getByKeyword(keyword);
            model.addAttribute("list", list);
        } else {
            List<Book> list = bookService.getAllBooks();
            model.addAttribute("list", list);
        }
        return "bookList";
    }*/





















}
