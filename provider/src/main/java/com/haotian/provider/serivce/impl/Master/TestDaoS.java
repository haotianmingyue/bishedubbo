package com.haotian.provider.serivce.impl.Master;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Test;
import com.haotian.api.MasterDatabase.Dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class TestDaoS implements TestDao {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> findAll() {
        return testDao.findAll();
    }

    @Override
    public List<Test> findAll(Sort sort) {
        return testDao.findAll(sort);
    }

    @Override
    public Page<Test> findAll(Pageable pageable) {
        return testDao.findAll(pageable);
    }

    @Override
    public List<Test> findAllById(Iterable<Long> iterable) {
        return testDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return testDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        testDao.deleteById(aLong);

    }

    @Override
    public void delete(Test test) {

        testDao.delete(test);
    }

    @Override
    public void deleteAll(Iterable<? extends Test> iterable) {

        testDao.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {

        testDao.deleteAll();
    }

    @Override
    public <S extends Test> S save(S s) {
        return testDao.save(s);
    }

    @Override
    public <S extends Test> List<S> saveAll(Iterable<S> iterable) {
        return testDao.saveAll(iterable);
    }

    @Override
    public Optional<Test> findById(Long aLong) {
        return testDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return testDao.existsById(aLong);
    }

    @Override
    public void flush() {
        testDao.flush();

    }

    @Override
    public <S extends Test> S saveAndFlush(S s) {
        return testDao.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Test> iterable) {
        testDao.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        testDao.deleteAllInBatch();

    }

    @Override
    public Test getOne(Long aLong) {
        return testDao.getOne(aLong);
    }

    @Override
    public <S extends Test> Optional<S> findOne(Example<S> example) {
        return testDao.findOne(example);
    }

    @Override
    public <S extends Test> List<S> findAll(Example<S> example) {
        return testDao.findAll(example);
    }

    @Override
    public <S extends Test> List<S> findAll(Example<S> example, Sort sort) {
        return testDao.findAll(example,sort);
    }

    @Override
    public <S extends Test> Page<S> findAll(Example<S> example, Pageable pageable) {
        return testDao.findAll(example,pageable);
    }

    @Override
    public <S extends Test> long count(Example<S> example) {
        return testDao.count();
    }

    @Override
    public <S extends Test> boolean exists(Example<S> example) {
        return testDao.exists(example);
    }
}
