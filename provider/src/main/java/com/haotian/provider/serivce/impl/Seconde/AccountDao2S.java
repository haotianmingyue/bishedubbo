package com.haotian.provider.serivce.impl.Seconde;


import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Account;
import com.haotian.api.SecondaryDatabase.Dao.AccountDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class AccountDao2S implements AccountDao2 {
    @Autowired
    private  AccountDao2 accountDao2;
    @Value("${dubbo.protocol.port}")
    private String dubboport;


    @Override
    public Account findById(long UserID) {

        System.out.println("得到账号"+dubboport);
        return accountDao2.findById(UserID);
    }

    @Override
    public List<Account> findAllByUserRole(String UserRole) {
        return accountDao2.findAllByUserRole(UserRole);
    }

    @Override
    public List<Account> findAll() {
        return accountDao2.findAll();
    }

    @Override
    public List<Account> findAll(Sort sort) {
        return accountDao2.findAll(sort);
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return findAll(pageable);
    }

    @Override
    public List<Account> findAllById(Iterable<Long> iterable) {
        return accountDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return accountDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        accountDao2.deleteById(aLong);

    }

    @Override
    public void delete(Account account) {
        accountDao2.delete(account);
    }

    @Override
    public void deleteAll(Iterable<? extends Account> iterable) {
        accountDao2.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        accountDao2.deleteAll();

    }

    @Override
    public <S extends Account> S save(S s) {
        return accountDao2.save(s);
    }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
        return accountDao2.saveAll(iterable);
    }

    @Override
    public Optional<Account> findById(Long aLong) {
        return accountDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return accountDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        accountDao2.flush();

    }

    @Override
    public <S extends Account> S saveAndFlush(S s) {
        return accountDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Account> iterable) {
        accountDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        accountDao2.deleteAllInBatch();

    }

    @Override
    public Account getOne(Long aLong) {
        return accountDao2.getOne(aLong);
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return accountDao2.findOne(example);
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return accountDao2.findAll(example);
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return accountDao2.findAll(example,sort);
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return accountDao2.findAll(example,pageable);
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return accountDao2.count(example);
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return accountDao2.exists(example);
    }
}
