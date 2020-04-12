package com.haotian.api.SecondaryDatabase.Dao;


import com.haotian.api.Entity.Question;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "userService")   //分页查询
public interface QuestionDao2 extends JpaRepository<Question,Long>, JpaSpecificationExecutor<Question> {
    List<Question> findAllByTestPaperID(long testPaperID);
    Question findById(long id);
}
