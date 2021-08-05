package com.example.tskTwo.Book;

import com.example.tskTwo.Genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){return bookService.getBooks();}

    @PostMapping
    public void registerNewBook(Book book){bookService.addNewBook(book);}

    @DeleteMapping
    public void deleteBook(Long bookId){bookService.deleteBook(bookId);}

    @PutMapping(path = "@{bookId}")
    public void putBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String ISBN,
            @RequestParam(required = false) Genre genre,
            @RequestParam(required = false) LocalDate dateOfCreation,
            @RequestParam(required = false) LocalDate dateOfModification){
        bookService.putBook(bookId, title, ISBN, genre, dateOfCreation, dateOfModification);
    }



}