package com.example.tskTwo.Genre;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Genre {
    @Id
    @SequenceGenerator(
            name = "genre_sequence",
            sequenceName = "genre_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
    )
    private long id;
    private String genreName;
    private String description;
    private LocalDate dateOfCreation;
    private LocalDate dateOfModification;

    public Genre() {
    }

    public Genre(String genreName, String description, LocalDate dateOfCreation, LocalDate dateOfModification) {
        this.genreName = genreName;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public Genre(long id, String genreName, String description, LocalDate dateOfCreation, LocalDate dateOfModification) {
        this.id = id;
        this.genreName = genreName;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public LocalDate getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDate dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "description='" + description + '\'' +
                '}';
    }
}
