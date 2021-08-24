package com.example.tskTwo.Author;

import com.example.tskTwo.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @RequestParam(required = false) LocalDate dateOfCreation,
            @RequestParam(required = false) LocalDate dateOfModification) {
        authorService.putAuthor(authorId,firstName, lastName, middleName, dateOfBirth, dateOfCreation, dateOfModification);
    }

    @PatchMapping("/Author/{id}/{dateOfModification}")
    public ResponseEntity<Author> updateAuthorPartially(@PathVariable Long id, @PathVariable LocalDate dateOfModification) {
        try {
            return new ResponseEntity<Author>(authorService.patchAuthor(id, dateOfModification), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
