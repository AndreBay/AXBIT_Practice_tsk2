package com.example.tskTwo.Book;

import com.example.tskTwo.Genre.Genre;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private long id;
    private String title;
    private String ISBN;
    private Genre genre;
    private LocalDate dateOfCreation;
    private LocalDate dateOfModification;

    public Book() {
    }

    public Book(String title, String ISBN, Genre genre, LocalDate dateOfCreation, LocalDate dateOfModification) {
        this.title = title;
        this.ISBN = ISBN;
        this.genre = genre;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public Book(long id, String title, String ISBN, Genre genre, LocalDate dateOfCreation, LocalDate dateOfModification) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.genre = genre;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDate getDateOfModification() {
        return dateOfModification;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setDateOfModification(LocalDate dateOfModification) {
        this.dateOfModification = dateOfModification;
    }
}
