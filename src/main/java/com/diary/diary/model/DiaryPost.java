package com.diary.diary.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Entity för DiaryPost med attributen postId, title, text och date som varsin blir en kolumn i databasen
@Entity
public class DiaryPost {
// Primary key för entityn blir postId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    private String title;

    private String text;

    private LocalDate date;


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    

    
}
