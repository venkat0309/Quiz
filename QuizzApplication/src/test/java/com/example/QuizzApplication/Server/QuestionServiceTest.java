package com.example.QuizzApplication.Server;

import com.example.QuizzApplication.Dao.QuestionDao;
import com.example.QuizzApplication.Entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionServiceTest {

    @Autowired
    private QuestionDao questionDao;

    @Test
    void saveQuestion()
    {
        Question question=Question.builder()
                .questionTitle("In java, what is the  default value of an uninitialized boolean variable?")
                .option1("true")
                .option2("false")
                .option3("1")
                .option4("null")
                .rightAnswer("true")
                .difficultylevel("Easy")
                .category("Java")
                .build();

        questionDao.save(question);

    }

    @Test
    void getAllQuestions()
    {
        List<Question> questions=questionDao.findAll();
        System.out.println(questions);
    }

    @Test
    void getAllQuestionsByCategory()
    {
        String category="jaVa";
        List<Question> questions=questionDao.findByCategory(category);
        System.out.println(questions);
    }

}