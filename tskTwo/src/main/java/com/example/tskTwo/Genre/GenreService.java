package com.example.tskTwo.Genre;

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
                    "Genre with ID = " + genreId + " does not exist"
            );
        }
        genreRepository.deleteById(genreId);
    }

    @Transactional
    public Genre putGenre(Long genreId, Genre newGenre){
        Genre genre = genreRepository.findById(genreId).
                orElseThrow(()-> new IllegalStateException(
                        "Genre with Id " + genreId + " does not exist"));

        if(newGenre.getGenreName() == null) throw new IllegalStateException("Genre name is equal to null");
        if(newGenre.getDescription() == null) throw new IllegalStateException("Genre description is equal to null");
        if(newGenre.getDateOfCreation() == null) throw new IllegalStateException("Genre DateOfCreation is equal to null");
        if(newGenre.getDateOfModification() == null) throw new IllegalStateException("Genre DateOfModification is equal to null");

        if(newGenre.getGenreName().length() > 0 && !Objects.equals(newGenre.getGenreName(), genre.getGenreName())){
            Optional<Genre> optionalGenre = genreRepository.findGenreByGenreName(newGenre.getGenreName());
            if(optionalGenre.isPresent()){
                throw new IllegalStateException("Genre Name" + newGenre.getGenreName() + "taken");
            }
            genre.setGenreName(newGenre.getGenreName());
        }
        if(newGenre.getDescription().length() > 0 && !Objects.equals(newGenre.getDescription(), genre.getDescription())){
            genre.setDescription(newGenre.getDescription());
        }
        if(!Objects.equals(newGenre.getDateOfCreation(), genre.getDateOfCreation())){
            genre.setDateOfCreation(newGenre.getDateOfCreation());
        }
        if(!Objects.equals(newGenre.getDateOfModification(), genre.getDateOfModification())){
            genre.setDateOfModification(newGenre.getDateOfModification());
        }
        return genre;
    }

    @Transactional
    public Genre patchGenre(Long genreId, Genre newGenre){
        Genre genre = genreRepository.findById(genreId).
                orElseThrow(()-> new IllegalStateException(
                        "Genre with Id " + genreId + " does not exist"));
        if(newGenre.getGenreName() != null && newGenre.getGenreName().length() > 0 && !Objects.equals(newGenre.getGenreName(), genre.getGenreName())){
            Optional<Genre> optionalGenre = genreRepository.findGenreByGenreName(newGenre.getGenreName());
            if(optionalGenre.isPresent()){
                throw new IllegalStateException("Genre Name" + newGenre.getGenreName() + "taken");
            }
            genre.setGenreName(newGenre.getGenreName());
        }
        if(newGenre.getDescription() != null && newGenre.getDescription().length() > 0 && !Objects.equals(newGenre.getDescription(), genre.getDescription())){
            genre.setDescription(newGenre.getDescription());
        }
        if(newGenre.getDateOfCreation() != null && !Objects.equals(newGenre.getDateOfCreation(), genre.getDateOfCreation())){
            genre.setDateOfCreation(newGenre.getDateOfCreation());
        }
        if(newGenre.getDateOfModification() != null && !Objects.equals(newGenre.getDateOfModification(), genre.getDateOfModification())){
            genre.setDateOfModification(newGenre.getDateOfModification());
        }
        return genre;
    }
}
