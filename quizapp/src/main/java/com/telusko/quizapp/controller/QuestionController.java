package com.telusko.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telusko.quizapp.entity.Question;
import com.telusko.quizapp.service.QuestionService;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService quizservice;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return quizservice.getAllQuestions();
    }

    @GetMapping("allQuestions/{category}")
    public ResponseEntity<List<Question>> getBycategory(@PathVariable String category) {
        return quizservice.getBycategory(category);
    }

    @PostMapping("allQuestions")
    public List<Question> putAllQuestions(@RequestBody List<Question> entity) {
        return quizservice.putAllQuestions(entity);
    }

}