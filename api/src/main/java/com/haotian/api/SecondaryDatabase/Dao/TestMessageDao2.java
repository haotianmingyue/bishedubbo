package com.haotian.api.SecondaryDatabase.Dao;



import com.haotian.api.Entity.TestMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMessageDao2 extends JpaRepository<TestMessage,Long> {
    List<TestMessage> findAllByTestGetterIDAndAndMessageIsConsult(long testGetterID, String messageIsConsult);
    TestMessage findByTestMessageID(long testMessageId);
}
