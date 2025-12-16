package com.diary.diary.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diary.diary.model.DiaryPost;

public interface DiaryRepository extends CrudRepository < DiaryPost, Integer >{
    
    
}
