package com.example.tskTwo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author){
        Optional<Author> optionalAuthor = authorRepository.findBookByAuthor(author.getFirstName(), author.getLastName(), author.getMiddleName(),
                author.getDateOfBirth());
        if(optionalAuthor.isPresent()){
            throw new IllegalStateException("The author is already exist");
        }
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId){
        boolean exist = authorRepository.existsById(authorId);
        if(!exist){
            throw new IllegalStateException("Author with id" + authorId + "does not exist");
        }
        authorRepository.deleteById(authorId);
    }

    /*@Transactional
    public void putAuthor(Long authorId, String firstName, String lastName, String middleName, LocalDate dateOfBirth, LocalDate dateOfCreation, LocalDate dateOfModification){
        Author author = authorRepository.findById(authorId).
                orElseThrow(() -> new IllegalStateException(
                        "Author with Id " + authorId + " does not exist"));

        if(firstName != null && firstName.length() > 0 && Objects.equals(firstName, author.getFirstName())){
            author.setFirstName(firstName);
        }
        if(lastName != null && lastName.length() > 0 && Objects.equals(lastName, author.getLastName())){
            author.setLastName(lastName);
        }
        if(middleName != null && Objects.equals(middleName, author.getMiddleName())){
            author.setMiddleName(middleName);
        }
        if(dateOfBirth != null && Objects.equals(dateOfBirth, author.getDateOfBirth())){
            author.setDateOfBirth(dateOfBirth);
        }
        if(dateOfCreation != null && Objects.equals(dateOfCreation, author.getDateOfCreation())){
            author.setDateOfCreation(dateOfBirth);
        }
        if(dateOfModification != null && Objects.equals(dateOfModification, author.getDateOfModification())){
            author.setDateOfModification(dateOfBirth);
        }
    }*/

    @Transactional
    public void putAuthor(Long authorId, Author newAuthor){
        Author author = authorRepository.findById(authorId).
                orElseThrow(() -> new IllegalStateException(
                        "Author with Id " + authorId + " does not exist"));

        if(newAuthor.getFirstName() != null && newAuthor.getFirstName().length() > 0 && Objects.equals(newAuthor.getFirstName(), author.getFirstName())){
            author.setFirstName(newAuthor.getFirstName());
        }
        if(newAuthor.getLastName() != null && newAuthor.getLastName().length() > 0 && Objects.equals(newAuthor.getLastName(), author.getLastName())){
            author.setLastName(newAuthor.getLastName());
        }
        if(newAuthor.getMiddleName() != null && Objects.equals(newAuthor.getMiddleName(), author.getMiddleName())){
            author.setMiddleName(newAuthor.getMiddleName());
        }
        if(newAuthor.getDateOfBirth() != null && Objects.equals(newAuthor.getDateOfBirth(), author.getDateOfBirth())){
            author.setDateOfBirth(newAuthor.getDateOfBirth());
        }
        if(newAuthor.getDateOfCreation() != null && Objects.equals(newAuthor.getDateOfCreation(), author.getDateOfCreation())){
            author.setDateOfCreation(newAuthor.getDateOfCreation());
        }
        if(newAuthor.getDateOfModification() != null && Objects.equals(newAuthor.getDateOfModification(), author.getDateOfModification())){
            author.setDateOfModification(newAuthor.getDateOfModification());
        }
    }

    @Transactional
    public Author patchAuthor(Long authorId, LocalDate dateOfModification){
        Author author = authorRepository.findById(authorId).
                orElseThrow(()-> new IllegalStateException(
                        "Author with Id " + authorId + " does not exist"));
        if(dateOfModification != null && Objects.equals(author.getDateOfModification(), dateOfModification)){
            author.setDateOfModification(dateOfModification);
        }
        return author;
    }
}
