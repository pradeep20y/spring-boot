package com.telusko.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.quizapp.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Long> {

}
