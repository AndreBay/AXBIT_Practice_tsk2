package com.example.tskTwo.Book;

import com.example.tskTwo.Genre.Genre;
import com.example.tskTwo.Genre.GenreConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository){
        return args -> {
            Book book = new Book(
                    "Romeo and Juliete",
                    "2-266-11156-6",
                    ,
                    LocalDate.of(1970, Month.JANUARY, 2),
                    LocalDate.of(1971, Month.JANUARY, 3)
            );
        }
    }
}
