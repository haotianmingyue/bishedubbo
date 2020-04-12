package com.haotian.api.SecondaryDatabase.Dao;


import com.haotian.api.Entity.Perinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerinformationDao2 extends JpaRepository<Perinformation,Long> {
Perinformation findByUserID(long userID);
Perinformation findByUserEmail(String userEmali);
}
