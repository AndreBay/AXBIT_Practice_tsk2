package com.example.tskTwo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Optional<Author> optionalAuthor = authorRepository.findBookByAuthor(author.getFirstName(), author.getLastName(), author.getMiddleName()
                );
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

    @Transactional
    public Author putAuthor(Long authorId, Author newAuthor){
        Author author = authorRepository.findById(authorId).
                orElseThrow(() -> new IllegalStateException(
                        "Author with Id " + authorId + " does not exist"));

        if(newAuthor.getFirstName() == null) throw new IllegalStateException("Author`s first name is equal to null");
        if(newAuthor.getLastName() == null) throw new IllegalStateException("Author`s last name is equal to null");
        if(newAuthor.getMiddleName() == null) throw new IllegalStateException("Author`s middle name is equal to null");
        if(newAuthor.getDateOfCreation() == null) throw new IllegalStateException("Author`s DateOfCreation is equal to null");
        if(newAuthor.getDateOfBirth() == null) throw new IllegalStateException("Author`s DateOfBirth is equal to null");
        if(newAuthor.getDateOfModification() == null) throw new IllegalStateException("Author`s DateOfModification is equal to null");

        if(newAuthor.getFirstName().length() > 0 && !Objects.equals(newAuthor.getFirstName(), author.getFirstName())){
            author.setFirstName(newAuthor.getFirstName());
        }
        if(newAuthor.getLastName().length() > 0 && !Objects.equals(newAuthor.getLastName(), author.getLastName())){
            author.setLastName(newAuthor.getLastName());
        }
        if(newAuthor.getMiddleName().length() > 0 && !Objects.equals(newAuthor.getMiddleName(), author.getMiddleName())){
            author.setMiddleName(newAuthor.getMiddleName());
        }
        if(!Objects.equals(newAuthor.getDateOfBirth(), author.getDateOfBirth())){
            author.setDateOfBirth(newAuthor.getDateOfBirth());
        }
        if(!Objects.equals(newAuthor.getDateOfCreation(), author.getDateOfCreation())){
            author.setDateOfCreation(newAuthor.getDateOfCreation());
        }
        if(!Objects.equals(newAuthor.getDateOfModification(), author.getDateOfModification())){
            author.setDateOfModification(newAuthor.getDateOfModification());
        }
        return author;
    }


    @Transactional
    public Author patchAuthor(Long authorId, Author newAuthor) {
        Author author = authorRepository.findById(authorId).
                orElseThrow(()-> new IllegalStateException(
                        "Author with Id " + authorId + " does not exist"));
        if(newAuthor.getFirstName() != null && newAuthor.getFirstName().length() > 0 && !Objects.equals(newAuthor.getFirstName(), author.getFirstName())){
            author.setFirstName(newAuthor.getFirstName());
        }
        if(newAuthor.getLastName() != null && newAuthor.getLastName().length() > 0 && !Objects.equals(newAuthor.getLastName(), author.getLastName())){
            author.setLastName(newAuthor.getLastName());
        }
        if(newAuthor.getMiddleName() != null && newAuthor.getMiddleName().length() > 0 && !Objects.equals(newAuthor.getMiddleName(), author.getMiddleName())){
            author.setMiddleName(newAuthor.getMiddleName());
        }
        if(newAuthor.getDateOfBirth() != null && !Objects.equals(newAuthor.getDateOfBirth(), author.getDateOfBirth())){
            author.setDateOfBirth(newAuthor.getDateOfBirth());
        }
        if(newAuthor.getDateOfCreation() != null && !Objects.equals(newAuthor.getDateOfCreation(), author.getDateOfCreation())){
            author.setDateOfCreation(newAuthor.getDateOfCreation());
        }
        if(newAuthor.getDateOfModification() != null && !Objects.equals(newAuthor.getDateOfModification(), author.getDateOfModification())){
            author.setDateOfModification(newAuthor.getDateOfModification());
        }
        return author;
    }
}
