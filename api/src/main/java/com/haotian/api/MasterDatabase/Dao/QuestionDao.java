package com.haotian.api.MasterDatabase.Dao;



import com.haotian.api.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Long> {

List<Question> findAllByTestPaperID(long testPaperID);
}
