package com.haotian.api.MasterDatabase.Dao;



import com.haotian.api.Entity.TestMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMessageDao extends JpaRepository<TestMessage,Long> {
}
