package com.example.tskTwo.Author;

import com.example.tskTwo.Book.Book;
import com.example.tskTwo.Genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Author")
public class AuthorConroller {
    private final AuthorService authorService;

    @Autowired
    public AuthorConroller(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public void registerNewAuthor(Author author) {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping
    public void deleteAuthor(Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping
    public void putAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) LocalDate dateOfBirth,
            @RequestParam(required = false) List<Book> books) {
        authorService.putAuthor(authorId,firstName, lastName, middleName, dateOfBirth, books);
    }
}
