package com.example.tskTwo.Genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Genre")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @PostMapping
    public void registerNewGenre(@RequestBody Genre genre){
        genreService.addNewGenre(genre);
    }

    @DeleteMapping("/{genreId}")
    public void deleteGenre(@PathVariable Long genreId){
        genreService.deleteGenre(genreId);
    }

    @PutMapping(path = "/{genreId}")
    public ResponseEntity<Genre> putGenre(
            @PathVariable("genreId") Long StudentId,
            @RequestBody Genre newGenre){
        try {
            return new ResponseEntity<Genre>(genreService.putGenre(StudentId, newGenre), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Genre> updateGenrePartially(@PathVariable Long id, @RequestBody Genre genre) {
        try {
            return new ResponseEntity<Genre>(genreService.patchGenre(id, genre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
