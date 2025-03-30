package com.telusko.quizapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quizapp.entity.QuizWrapper;
import com.telusko.quizapp.entity.Response;
import com.telusko.quizapp.service.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizservice;

    @PostMapping("createquiz/{category}/{title}")
    public ResponseEntity<String> postMethodName(@PathVariable String category, @PathVariable String title) {
        return quizservice.createQuiz(category, title);
    }

    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<QuizWrapper>> getMethodName(@PathVariable Long id) {
        return quizservice.getMethodName(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> SubmitResponse(@PathVariable Long id, @RequestBody List<Response> response) {
        return quizservice.submitResponse(id, response);
    }

}
