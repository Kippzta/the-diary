package com.diary.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diary.diary.DiaryService.DiaryService;

@Controller
public class HomeController {
    // Aurowired gör så att Spring boot automatiskt skapar en instans av DiaryService
    @Autowired

    private DiaryService diaryService;

    // Metod för att visa alla poster på startsidan (home)
    // Använder service klassen för att hämta alla poster upp till dagens datum från databasen(Framtida posts syns bara i databasen)
    @GetMapping({ "/", "/home" })
    private String getHome(Model model) {
        model.addAttribute("posts", diaryService.findPostUpToCurrentDate(java.time.LocalDate.now()));
        return "home";
    }

}
