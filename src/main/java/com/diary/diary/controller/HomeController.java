package com.diary.diary.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.diary.diary.repositories.DiaryRepository;

@Controller
public class HomeController {

    @Autowired

    private DiaryRepository diaryRepository;

    @GetMapping({"/", "/home"})
    private String getHome(Model model){

        model.addAttribute("posts", diaryRepository.findAll());

        return "home";
    }

}
