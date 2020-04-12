package com.haotian.api.MasterDatabase.Dao;


import com.haotian.api.Entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperDao extends JpaRepository<Paper,Long> {
    @Modifying
    @Query("update Paper p set p.testIsApproved=?2 where  p.testPaperID=?1")
    void updateStateByMoney(Long testPaperID, String testIsApproved);
    Paper findByTestPaperID(long testPaperID);

}

