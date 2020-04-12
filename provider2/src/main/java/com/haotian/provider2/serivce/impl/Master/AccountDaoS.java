package com.haotian.provider2.serivce.impl.Master;


import com.alibaba.dubbo.config.annotation.Service;
import com.haotian.api.Entity.Account;
import com.haotian.api.MasterDatabase.Dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class AccountDaoS implements AccountDao {
    @Autowired
    private  AccountDao accountDao;


    @Override
    public Account findById(long UserID) {

        return accountDao.findById(UserID);
    }

    @Override
    public List<Account> findAllByUserRole(String UserRole) {
        return accountDao.findAllByUserRole(UserRole);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public List<Account> findAll(Sort sort) {
        return accountDao.findAll(sort);
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return findAll(pageable);
    }

    @Override
    public List<Account> findAllById(Iterable<Long> iterable) {
        return accountDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return accountDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        accountDao.deleteById(aLong);

    }

    @Override
    public void delete(Account account) {
        accountDao.delete(account);
    }

    @Override
    public void deleteAll(Iterable<? extends Account> iterable) {
        accountDao.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        accountDao.deleteAll();

    }

    @Override
    public <S extends Account> S save(S s) {
        return accountDao.save(s);
    }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
        return accountDao.saveAll(iterable);
    }

    @Override
    public Optional<Account> findById(Long aLong) {
        return accountDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return accountDao.existsById(aLong);
    }

    @Override
    public void flush() {
        accountDao.flush();

    }

    @Override
    public <S extends Account> S saveAndFlush(S s) {
        return accountDao.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Account> iterable) {
        accountDao.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        accountDao.deleteAllInBatch();

    }

    @Override
    public Account getOne(Long aLong) {
        return accountDao.getOne(aLong);
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return accountDao.findOne(example);
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return accountDao.findAll(example);
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return accountDao.findAll(example,sort);
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return accountDao.findAll(example,pageable);
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return accountDao.count(example);
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return accountDao.exists(example);
    }
}
