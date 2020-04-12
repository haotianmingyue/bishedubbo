package com.haotian.api.MasterDatabase.Dao;



import com.haotian.api.Entity.Perinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerinformationDao extends JpaRepository<Perinformation,Long> {
}
