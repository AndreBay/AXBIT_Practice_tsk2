package com.example.tskTwo.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE (a.firstName = ?1) AND (a.lastName = ?1) AND (a.middleName = ?1) "
            )
    Optional<Author> findBookByAuthor(String firstName, String lastName, String middleName);

}
