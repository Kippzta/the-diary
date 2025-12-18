package com.diary.diary.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diary.diary.model.DiaryPost;
import com.diary.diary.repositories.DiaryRepository;

@Controller
public class PostController {

    @Autowired

    // Repository för DiaryPost för att kunna hantera CRUD operationer ifrån min controller
    private DiaryRepository diaryRepository;

    // Metod för att lägga till en ny post
    // Sickar in ett helt DiaryPost objekt som skapas från formuläret i newPost.html
    // med attributen i ordning title, text och date.
    @PostMapping("/newPost")
    private String addNewPost(@ModelAttribute DiaryPost diaryPost) {
        diaryRepository.save(diaryPost);

        return "redirect:/home";
    }

    // Metod för att kunna visa en viss post baserat på dess ID
    @GetMapping("/showPost/{postId}")
    private String showPost(@PathVariable int postId, Model model) {
        DiaryPost post = diaryRepository.findById(postId).orElse(null);
        model.addAttribute("post", post);
        return "showPost";
    }

    // Metod för att redigera en post baserat på dess ID
    @PostMapping("/editPost/{postId}")
    private String editPost(@ModelAttribute DiaryPost diaryPost) {
        diaryRepository.save(diaryPost);
        return "redirect:/showPost/" + diaryPost.getPostId();
    }

    // Metod för att ta bort en post baserat på dess ID
    @PostMapping("/deletePost/{postId}")
    private String deletePost(@PathVariable int postId) {
        diaryRepository.deleteById(postId);
        return "redirect:/home";
    }


    // Filtrering av poster mellan två datum 
    // Kollar om "from" daturmet är efter "to" datumet
    // Kollar om listan är tom efter filtrering
    // om inget av detta är fallet så visas de filtrerade posterna utom framtida posts
    @GetMapping("/filterPost")
    private String filterPost(@RequestParam("from") LocalDate from,
            @RequestParam("to") LocalDate to, Model model) {

        if (from.isAfter(to)) {
            model.addAttribute("error", "From-date cant be after To-date when filtering.");
            model.addAttribute("posts", diaryRepository.findByDateLessThanEqual(java.time.LocalDate.now()));
            return "home";
        }

        List<DiaryPost> filteredPosts = diaryRepository.findByDateBetweenAndDateLessThanEqual(from, to, java.time.LocalDate.now());
        if (filteredPosts.isEmpty()) {
            model.addAttribute("error", "There are no entries found between these dates.");
        }
        model.addAttribute("posts", filteredPosts);
        return "home";

    }
}
