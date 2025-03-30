package com.telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.entity.Question;
import com.telusko.quizapp.entity.Quiz;
import com.telusko.quizapp.entity.QuizWrapper;
import com.telusko.quizapp.entity.Response;
import com.telusko.quizapp.repository.QuestionDao;

import com.telusko.quizapp.repository.QuizDao;

@Service
public class QuizService {

    @Autowired
    QuestionDao questionDao;
    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> createQuiz(String category, String title) {

        List<Question> question = questionDao.findRandomQuestionsByCategory(category);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuizWrapper>> getMethodName(long id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> question = quiz.get().getQuestions();

        List<QuizWrapper> quizWrappers = new ArrayList<>();

        for (Question q : question) {
            quizWrappers.add(
                    new QuizWrapper(q.getID(), q.getQuestion(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4()));
        }
        return new ResponseEntity<>(quizWrappers, HttpStatus.OK);

    }

    public ResponseEntity<String> submitResponse(Long id, List<Response> response) {

        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i = 0, correctans = 0;
        for (Response res : response) {
            if (res.getResponse().equals(questions.get(i).getRightans()))
                correctans++;
            i++;
        }

        return new ResponseEntity(String.valueOf(correctans), HttpStatus.OK);

    }
}
