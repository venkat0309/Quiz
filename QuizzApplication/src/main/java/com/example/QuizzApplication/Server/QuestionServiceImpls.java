package com.example.QuizzApplication.Server;

import com.example.QuizzApplication.Dao.QuestionDao;
import com.example.QuizzApplication.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpls implements QuestionService{

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questions= questionDao.findByCategoryIgnoreCase(category);
        if(questions.isEmpty())
            //throw  new RuntimeException("Did not find questions in these category :"+category);
            throw new RuntimeException("Did not find questions in these category :"+ category);
        else
            return questions;
    }

    @Override
    public void addQuestion(Question question) {
        questionDao.save(question);
    }


}
