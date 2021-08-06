package com.example.tskTwo.Author;

import com.example.tskTwo.Book.Book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
    @ManyToMany
    @JoinTable(
            name="BOOK",
            joinColumns=@JoinColumn(name="ID_AUTHOR", referencedColumnName="ID_AUTHOR"),
            inverseJoinColumns=@JoinColumn(name="ID_BOOK", referencedColumnName="ID_BOOK"))
    private List<Book> book = new ArrayList<>();

    public Author() {
    }

    public Author(String firstName, String lastName, String middleName, LocalDate dateOfBirth, List<Book> book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.book = book;
    }

    public Author(long id, String firstName, String lastName, String middleName, LocalDate dateOfBirth, List<Book> book) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBook(List<Book> books) {
        this.book = books;
    }
}
