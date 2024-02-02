package com.example.QuizzApplication.Controller;

import com.example.QuizzApplication.Entity.Question;
import com.example.QuizzApplication.Entity.Response;
import com.example.QuizzApplication.Server.QuizService;
import com.example.QuizzApplication.Wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num_ques, @RequestParam String difficultylevel,@RequestParam String title)
    {
        return quizService.create(category,num_ques,difficultylevel,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
        return quizService.getQuizQuestions(id);
    }


    // response for user( quizz submission
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id,@RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id,responses);
    }
}
