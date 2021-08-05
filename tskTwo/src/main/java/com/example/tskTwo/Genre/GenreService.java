package com.example.tskTwo.Genre;

import com.example.tskTwo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public void addNewGenre(Genre genre) {
        Optional<Genre> genreOptional = genreRepository.
                findGenreByGenreName(genre.getGenreName());
        if(genreOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        genreRepository.save(genre);
    }

    public void deleteGenre(Long genreId) {
        boolean exists = genreRepository.existsById(genreId);
        if(!exists){
            throw new IllegalStateException(
                    "Student with ID = " + genreId + " does not exist"
            );
        }
        genreRepository.deleteById(genreId);
    }

    @Transactional
    public void putGenre(Long genreId, String genreName, String description, LocalDate dateOfCreation, LocalDate dateOfModification){
        Genre genre = genreRepository.findById(genreId).
                orElseThrow(()-> new IllegalStateException(
                        "Student with Id " + genreId + " does not exist"));
        if(genreName != null && genreName.length() > 0 && !Objects.equals(genreName, genre.getGenreName())){
            Optional<Genre> optionalGenre = genreRepository.findGenreByGenreName(genreName);
            if(optionalGenre.isPresent()){
                throw new IllegalStateException("Genre Name" + genreName + "taken");
            }
            genre.setGenreName(genreName);
        }
        if(description != null && description.length() > 0 && !Objects.equals(description, genre.getDescription())){
            genre.setDescription(description);
        }
        if(dateOfCreation != null && Objects.equals(dateOfCreation, genre.getDateOfCreation())){
            genre.setDateOfCreation(dateOfCreation);
        }
        if(dateOfModification != null && Objects.equals(dateOfModification, genre.getDateOfModification())){
            genre.setDateOfModification(dateOfModification);
        }
    }
}
