package com.example.QuizzApplication.Server;

import com.example.QuizzApplication.Dao.QuestionDao;
import com.example.QuizzApplication.Dao.QuizDao;
import com.example.QuizzApplication.Entity.Question;
import com.example.QuizzApplication.Entity.Quiz;
import com.example.QuizzApplication.Entity.Response;
import com.example.QuizzApplication.Wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpls implements QuizService{

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;
    @Override
    public ResponseEntity<String> create(String category, int numQues, String difficultylevel, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQues,difficultylevel);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setCategory(category);
        quiz.setQuestions(questions);
        quiz.setDifficultylevel(difficultylevel);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz=quizDao.findById(id);
        if(quiz.isEmpty())
            throw new RuntimeException("Did not there questions :"+id);
        List<Question> questions=quiz.get().getQuestions();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();

        for(Question q:questions) {
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionWrappers.add(questionWrapper);
        }

        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0,i=0;
        for(Response response:responses)
        {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
