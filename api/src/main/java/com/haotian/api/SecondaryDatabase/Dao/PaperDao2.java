package com.haotian.api.SecondaryDatabase.Dao;


import com.haotian.api.Entity.Paper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "userService")
public interface PaperDao2 extends JpaRepository<Paper,Long> {
    List<Paper> findAllByTestQuestionSetterID(long testQuestionSetterID);
    List<Paper> findAllByTestIsApproved(String isApproved);
    Paper findByTestPaperID(Long testPaperID);

}

