package com.diary.diary.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.diary.diary.model.DiaryPost;
import com.diary.diary.repositories.DiaryRepository;

@Controller
public class PostController {

    @Autowired

    private DiaryRepository diaryRepository;

     @PostMapping ("/newPost")
    private String addNewPost(@ModelAttribute DiaryPost diaryPost) {
        diaryRepository.save(diaryPost);
        
        return "redirect:/home";
    }

    
}
