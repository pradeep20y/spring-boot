package com.telusko.quizapp.service;

import com.telusko.quizapp.entity.Question;
import com.telusko.quizapp.repository.QuestionDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> putAllQuestions(List<Question> question) {

        return questionDao.saveAll(question);
    }

    public ResponseEntity<List<Question>> getBycategory(String category) {
        return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
    }
}
