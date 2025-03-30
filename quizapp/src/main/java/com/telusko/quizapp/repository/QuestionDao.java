package com.telusko.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusko.quizapp.entity.Question;
import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    public List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM quizentity q WHERE q.category = :category ORDER BY RAND() LIMIT 5", nativeQuery = true)
    public List<Question> findRandomQuestionsByCategory(@Param("category") String category);

}
