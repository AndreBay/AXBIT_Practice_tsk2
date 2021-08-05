package com.example.tskTwo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mar = new Student(
                    "Mar",
                    "Mar@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,30),
                    21
            );
            Student alex = new Student(
                    "Alex",
                    "Alex@gmail.com",
                    LocalDate.of(1999, Month.FEBRUARY,1),
                    22
            );
            repository.saveAll(List.of(mar,alex));
        };
    }
}
