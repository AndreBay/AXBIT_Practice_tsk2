package com.example.tskTwo.Book;

import com.example.tskTwo.Author.Author;
import com.example.tskTwo.Genre.Genre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    private long id;
    private String title;
    private String ISBN;
    private LocalDate dateOfCreation;
    private LocalDate dateOfModification;

    private Genre genre;
    private List<Author> authors;

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

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "ISBN", nullable = false, length = 13)
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Basic
    @Column(name = "date_of_creation")
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }
    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Basic
    @Column(name = "date_of_modification")
    public LocalDate getDateOfModification() {
        return dateOfModification;
    }
    public void setDateOfModification(LocalDate dateOfModification) {
        this.dateOfModification = dateOfModification;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToMany(mappedBy = "books")
    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }
}
