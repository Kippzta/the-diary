package com.diary.diary.DiaryService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.diary.model.DiaryPost;
import com.diary.diary.repositories.DiaryRepository;


// Hjälp taget ifrån https://anilr9.medium.com/understanding-service-in-spring-boot-a-complete-guide-with-examples-b08825e8ccd8
// Service klass som hatnterar logiken mellan controller och repository lagret
// Controllern anropar metoder i denna klass för att hantera DiaryPost objekt
// Denna klass skickar i sin tur anrop till DiaryRepository som hanterar operationerna motdatabasen
@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    // Metod för att spara en DiaryPost i databasen
    public void savePost(DiaryPost diaryPost) {
        diaryRepository.save(diaryPost);
    }

    // Metod för att hitta en post baserat på dess ID
    public DiaryPost findPostById(int postId) {
        return diaryRepository.findById(postId).orElse(null);
    }

    // Metod för att ta bort en post baserat på dess ID
    public void deletePostById(int postId) {
        diaryRepository.deleteById(postId);
    }

    // Metod för att hämta alla poster upp till dagens datum
    public List<DiaryPost> findPostUpToCurrentDate(LocalDate maxDate) {
        return diaryRepository.findByDateLessThanEqual(maxDate);
    }

    // Metod för att hämta poster mellan två datum och upp till dagens datum
    public List<DiaryPost> findPostBetweenDateAndUpToCurrentDate(LocalDate from, LocalDate to, LocalDate maxDate) {
        return diaryRepository.findByDateBetweenAndDateLessThanEqual(from, to, maxDate);
    }


}
