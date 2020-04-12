package com.haotian.api.SecondaryDatabase.Dao;



import com.haotian.api.Entity.Account;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "userService")
public interface AccountDao2 extends JpaRepository<Account,Long> {
    Account findById(long UserID);
    List<Account> findAllByUserRole(String UserRole);
}
