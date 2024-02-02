package com.example.QuizzApplication.Server;

import com.example.QuizzApplication.Entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    List<Question> getQuestionsByCategory(String category);

    void addQuestion(Question question);
}
