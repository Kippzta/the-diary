package com.diary.diary.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.diary.diary.model.DiaryPost;
import com.diary.diary.repositories.DiaryRepository;

@Controller
public class PostController {

    @Autowired

    private DiaryRepository diaryRepository;

     @GetMapping ("/newPost")
    private String addNewPost() {
        DiaryPost diaryPost = new DiaryPost();
        diaryPost.setTitle("astrid fittgren");
        diaryPost.setText("Hejsan alla cp barn!");
        diaryPost.setDate(LocalDate.now());
        diaryRepository.save(diaryPost);

        return "redirect:/home";
    }

    
}
