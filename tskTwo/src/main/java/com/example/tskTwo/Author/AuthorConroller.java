package com.example.tskTwo.Author;

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
    public void registerNewAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    /*@PutMapping("/{author_id}")
    public void putAuthor(
            @PathVariable("author_id") Long author_id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) LocalDate dateOfBirth,
            @RequestParam(required = false) LocalDate dateOfCreation,
            @RequestParam(required = false) LocalDate dateOfModification) {
        authorService.putAuthor(author_id,firstName, lastName, middleName, dateOfBirth, dateOfCreation, dateOfModification);
    }*/

    @PutMapping("/{author_id}")
    public void putAuthor(
            @PathVariable("author_id") Long author_id,
            @RequestBody Author author) {
        authorService.putAuthor(author_id, author);
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
