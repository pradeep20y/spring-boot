package com.telusko.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizWrapper {
    private long id;
    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
}
