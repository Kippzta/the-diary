package com.diary.diary.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.diary.diary.model.DiaryPost;

public interface DiaryRepository extends CrudRepository < DiaryPost, Integer >{
    
    // Exmepel som jag hittade från stackoverflow https://stackoverflow.com/questions/59493453/filter-list-by-date-value
    //samt https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    // Metod för att hämta poster mellan två datum
    List<DiaryPost> findByDateBetween(LocalDate from, LocalDate to);

    // Metod för att hämta alla poster upp till dagens datum
   List<DiaryPost> findByDateLessThanEqual(LocalDate maxDate);

   // Extra metod för att undvika att framtida datum visas vid filtrering
   List<DiaryPost> findByDateBetweenAndDateLessThanEqual(LocalDate form, LocalDate to, LocalDate maxDate); 
   
}
