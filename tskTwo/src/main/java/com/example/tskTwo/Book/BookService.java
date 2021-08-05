package com.example.tskTwo.Book;

import com.example.tskTwo.Genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){return bookRepository.findAll();}

    public void addNewBook(Book book){
        Optional<Book> optionalBook = bookRepository.findBookByGenreTitle(book.getTitle());
        if(optionalBook.isPresent()){
            throw new IllegalStateException("Title " + book.getTitle() + " taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        Boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id" + bookId + "does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void putBook(Long bookId, String title, String ISBN, Genre genre, LocalDate dateOfCreation,LocalDate dateOfModification) {
        Book book = bookRepository.findById(bookId).
                orElseThrow(() -> new IllegalStateException(
                        "Book with Id " + bookId + " does not exist"));
        if(title != null && title.length() > 0 && !Objects.equals(title, book.getTitle())){
            Optional<Book> optionalBook = bookRepository.findBookByGenreTitle(title);
            if(optionalBook.isPresent()){
                throw new IllegalStateException("Book title" + title + "taken");
            }
            book.setTitle(title);
        }
        if(ISBN != null && !Objects.equals(ISBN, book.getISBN())){
            book.setISBN(ISBN);
        }
        if(genre != null && !Objects.equals(genre, book.getGenre())){
            book.setGenre(genre);
        }
        if( dateOfCreation != null && !Objects.equals(dateOfCreation, book.getDateOfCreation())){
            book.setDateOfCreation(dateOfCreation);
        }
        if(dateOfModification != null && !Objects.equals(dateOfModification, book.getDateOfModification())){
            book.setDateOfModification(dateOfModification);
        }                                                      
    }
}
