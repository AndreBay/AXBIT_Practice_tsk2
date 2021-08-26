package com.example.tskTwo.Author;

import com.example.tskTwo.Book.Book;
import com.example.tskTwo.Genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{author_id}")
    @ResponseBody
    public ResponseEntity<Author> putAuthor(
            @PathVariable("author_id") Long author_id,
            @RequestBody Author author) {
        try {
            return new ResponseEntity<Author>(authorService.putAuthor(author_id, author), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Author> patchAuthor(@RequestBody Author author, @PathVariable("id") Long author_id){

        try {
            return new ResponseEntity<Author>(authorService.patchAuthor(author_id, author), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
