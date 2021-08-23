package com.example.tskTwo.Genre;

import com.example.tskTwo.Book.Book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

    private long id;
    private String genreName;
    private String description;
    private LocalDate dateOfCreation;
    private LocalDate dateOfModification;
    private List<Book> books;

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

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "genreName", nullable = false, length = 100)
    public String getGenreName() {
        return genreName;
    }
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Basic
    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "dateOfCreation")
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }
    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Basic
    @Column(name = "dateOfModification")
    public LocalDate getDateOfModification() {
        return dateOfModification;
    }
    public void setDateOfModification(LocalDate dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName = '" + genreName + '\'' +
                "description = '" + description + '\'' +
                "dateOfCreation = '" + dateOfCreation + '\'' +
                "dateOfModification = '" + dateOfModification + '\'' +
                '}';
    }
}
