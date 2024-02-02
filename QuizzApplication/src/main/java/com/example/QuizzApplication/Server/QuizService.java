package com.example.QuizzApplication.Server;

import com.example.QuizzApplication.Entity.Response;
import com.example.QuizzApplication.Wrapper.QuestionWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<String> create(String category, int numQues, String difficultylevel, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
