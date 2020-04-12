package com.haotian.api.SecondaryDatabase.Dao;



import com.haotian.api.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao2 extends JpaRepository<Test,Long> {
    List<Test>findAllByTestRespondentID(long testRespondentID);
    List<Test>findAllByTestRespondentIDAndIsConsult(long testRespondentID, String isConsult);
    List<Test>findAllByTestQuestionSetterIDAndIsConsult(long testSetterID, String isConsult);
    Test findByTestID(long testID);
}
