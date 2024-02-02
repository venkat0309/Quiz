package com.example.QuizzApplication.Dao;

import com.example.QuizzApplication.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    List<Question> findByCategoryIgnoreCase(String category);

    @Query(
            value = "select * from question q where q.category=:category AND q.difficultylevel=:difficultylevel ORDER BY RAND() LIMIT :numQues",
            nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(String category, int numQues, String difficultylevel);
}
