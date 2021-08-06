package com.example.tskTwo.Genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GenreConfig {
    @Bean
    CommandLineRunner commandLineRunner(GenreRepository repository) {
        return args -> {
            Genre taskbook = new Genre("taskbook",
                    "Tasks to improve your brain",
                    LocalDate.of(1950, Month.OCTOBER, 14),
                    LocalDate.of(1950, Month.OCTOBER, 14)
            );
            Genre pulpFiction = new Genre("Pulp Fiction",
                    "no_description",
                    LocalDate.of(1960, Month.NOVEMBER, 1),
                    LocalDate.of(1974, Month.MARCH, 31)
            );
            Genre scienceFiction = new Genre("Science Fiction",
                    "Science for dumies",
                    LocalDate.of(1800, Month.NOVEMBER, 1),
                    LocalDate.of(1805, Month.MARCH, 31)
            );
            Genre romantic = new Genre(
                    "Romantic",
                    "About love",
                    LocalDate.of(1670, Month.JANUARY, 2),
                    LocalDate.of(1756, Month.AUGUST, 25)
            );
            repository.saveAll(List.of(taskbook, pulpFiction, scienceFiction, romantic));
        };
    }
}
