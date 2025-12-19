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

import com.diary.diary.service.DiaryService;
import com.diary.diary.model.DiaryPost;


// Tar emot anropen från front-end gällande DiaryPost och använder DiaryService för att hantera logiken mot databasen

@Controller
public class PostController {

    @Autowired
    // Aurowired gör så att Spring boot automatiskt skapar en instans av DiaryService
    // Detta gör så att man slipper skapa en instans manuellt i varje metod den ska användas
    private DiaryService diaryService;

   

    // Metod för att lägga till en ny post
    // Sickar in ett helt DiaryPost objekt som skapas från formuläret i newPost.html
    // med attributen i ordning title, text och date.
    // Använder service klassen för att spara posten i databasen
    @PostMapping("/newPost")
    private String addNewPost(@ModelAttribute DiaryPost diaryPost) {
        diaryService.savePost(diaryPost);
        return "redirect:/home";
    }

    // Metod för att kunna visa en viss post baserat på dess ID
    // Använder service klassen för att hämta posten från databasen
    @GetMapping("/showPost/{postId}")
    private String showPost(@PathVariable int postId, Model model) {
        DiaryPost post = diaryService.findPostById(postId);
        model.addAttribute("post", post);
        return "showPost";
    }

    // Metod för att redigera en post baserat på dess ID
    // Använder service klassen för att spara den redigerade posten i databasen
    @PostMapping("/editPost/{postId}")
    private String editPost(@ModelAttribute DiaryPost diaryPost) {
        diaryService.savePost(diaryPost);
        return "redirect:/showPost/" + diaryPost.getPostId();
    }

    // Metod för att ta bort en post baserat på dess ID
    // Använder service klassen för att ta bort posten från databasen
    @PostMapping("/deletePost/{postId}")
    private String deletePost(@PathVariable int postId) {
        diaryService.deletePostById(postId);
        return "redirect:/home";
    }


    // Filtrering av poster mellan två datum 
    // Kollar om "from" daturmet är efter "to" datumet
    // Kollar om listan är tom efter filtrering
    // om inget av detta är fallet så visas de filtrerade posterna utom framtida posts
    // Använder service klassen för att hämta de filtrerade posterna från databasen
    @GetMapping("/filterPost")
    private String filterPost(@RequestParam("from") LocalDate from,
            @RequestParam("to") LocalDate to, Model model) {

        if (from.isAfter(to)) {
            model.addAttribute("error", "From-date cant be after To-date when filtering sillygoose.");
            model.addAttribute("posts", diaryService.findPostUpToCurrentDate(java.time.LocalDate.now()));
            return "home";
        }

        List<DiaryPost> filteredPosts = diaryService.findPostBetweenDateAndUpToCurrentDate(from, to, java.time.LocalDate.now());
        if (filteredPosts.isEmpty()) {
            model.addAttribute("error", "No entries found between these dates.");
        }
        model.addAttribute("posts", filteredPosts);
        return "home";

    }
}
