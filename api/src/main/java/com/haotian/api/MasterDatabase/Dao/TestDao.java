package com.haotian.api.MasterDatabase.Dao;



import com.haotian.api.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<Test,Long> {
}
