package com.example.tskTwo.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void registerNewBook(@RequestBody Book book){bookService.addNewBook(book);}

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){bookService.deleteBook(bookId);}

    @PutMapping(path = "/{bookId}")
    public ResponseEntity<Book> putBook(
            @PathVariable("bookId") Long bookId,
            @RequestBody Book newBook){
        try {
            return new ResponseEntity<Book>(bookService.putBook(bookId, newBook), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBookPartially(@PathVariable Long id, @RequestBody Book newBook) {
        try {
            return new ResponseEntity<Book>(bookService.patchBook(id, newBook), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
