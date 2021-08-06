package com.example.tskTwo.Genre;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void registerNewGenre(Genre genre){
        genreService.addNewGenre(genre);
    }

    @DeleteMapping
    public void deleteGenre(@PathVariable ("genreId")Long genreId){
        genreService.deleteGenre(genreId);
    }

    @PutMapping(path = "@{GenreId}")
    public void putGenre(
            @PathVariable("GenreId") Long StudentId,
            @RequestParam(required = false) String genreName,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) LocalDate dateOfCreation,
            @RequestParam(required = false) LocalDate dateOfModification){
        genreService.putGenre(StudentId, genreName, description, dateOfCreation, dateOfModification);

    }
}
