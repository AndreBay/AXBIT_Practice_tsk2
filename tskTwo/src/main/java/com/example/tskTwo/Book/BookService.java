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
    public Book putBook(Long bookId, Book newBook) {
        Book book = bookRepository.findById(bookId).
                orElseThrow(() -> new IllegalStateException(
                        "Book with Id " + bookId + " does not exist"));
        if(newBook.getTitle() == null) throw new IllegalStateException("Book title is equal to null");
        if(newBook.getISBN() == null) throw new IllegalStateException("Book ISBN is equal to null");
        if(newBook.getDateOfCreation() == null) throw new IllegalStateException("Book DateOfCreation is equal to null");
        if(newBook.getDateOfModification() == null) throw new IllegalStateException("Book DateOfModification is equal to null");


        if(newBook.getTitle().length() > 0 && !Objects.equals(newBook.getTitle(), book.getTitle())){
            Optional<Book> optionalBook = bookRepository.findBookByGenreTitle(newBook.getTitle());
            if(optionalBook.isPresent()){
                throw new IllegalStateException("Book title" + newBook.getTitle() + "taken");
            }
            book.setTitle(newBook.getTitle());
        }
        if(!Objects.equals(newBook.getISBN(), book.getISBN())){
            book.setISBN(newBook.getISBN());
        }
        if(!Objects.equals(newBook.getDateOfCreation(), book.getDateOfCreation())){
            book.setDateOfCreation(newBook.getDateOfCreation());
        }
        if(!Objects.equals(newBook.getDateOfModification(), book.getDateOfModification())){
            book.setDateOfModification(newBook.getDateOfModification());
        }
        return book;
    }

    @Transactional
    public Book patchBook(Long bookId, Book newBook){
        Book book = bookRepository.findById(bookId).
                orElseThrow(()-> new IllegalStateException(
                        "Book with Id " + bookId + " does not exist"));
        if(newBook.getTitle() != null && newBook.getTitle().length() > 0 && !Objects.equals(newBook.getTitle(), book.getTitle())){
            Optional<Book> optionalBook = bookRepository.findBookByGenreTitle(newBook.getTitle());
            if(optionalBook.isPresent()){
                throw new IllegalStateException("Book title" + newBook.getTitle() + "taken");
            }
            book.setTitle(newBook.getTitle());
        }
        if(newBook.getISBN() != null && !Objects.equals(newBook.getISBN(), book.getISBN())){
            book.setISBN(newBook.getISBN());
        }
        if(newBook.getGenre() != null && !Objects.equals(newBook.getGenre(), book.getGenre())){
            book.setGenre(newBook.getGenre());
        }
        if(newBook.getDateOfCreation() != null && !Objects.equals(newBook.getDateOfCreation(), book.getDateOfCreation())){
            book.setDateOfCreation(newBook.getDateOfCreation());
        }
        if(newBook.getDateOfModification() != null && !Objects.equals(newBook.getDateOfModification(), book.getDateOfModification())){
            book.setDateOfModification(newBook.getDateOfModification());
        }
        return book;
    }

}
