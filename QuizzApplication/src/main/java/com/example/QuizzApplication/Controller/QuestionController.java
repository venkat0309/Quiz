package com.example.QuizzApplication.Controller;

import com.example.QuizzApplication.Entity.Question;
import com.example.QuizzApplication.Server.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/allQuestionsByCategory/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question)
    {
        questionService.addQuestion(question);
        return "Success";
    }
}
