package com.haotian.provider.serivce.impl.Master;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.TestMessage;
import com.haotian.api.MasterDatabase.Dao.TestMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class TestMessageDaoS implements TestMessageDao {

    @Autowired
    private  TestMessageDao testMessageDao;

    @Override
    public List<TestMessage> findAll() {
        return testMessageDao.findAll();
    }

    @Override
    public List<TestMessage> findAll(Sort sort) {
        return testMessageDao.findAll(sort);
    }

    @Override
    public Page<TestMessage> findAll(Pageable pageable) {
        return testMessageDao.findAll(pageable);
    }

    @Override
    public List<TestMessage> findAllById(Iterable<Long> iterable) {
        return testMessageDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return testMessageDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        testMessageDao.deleteById(aLong);

    }

    @Override
    public void delete(TestMessage testMessage) {
        testMessageDao.delete(testMessage);

    }

    @Override
    public void deleteAll(Iterable<? extends TestMessage> iterable) {
        testMessageDao.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        testMessageDao.deleteAll();

    }

    @Override
    public <S extends TestMessage> S save(S s) {
        return testMessageDao.save(s);
    }

    @Override
    public <S extends TestMessage> List<S> saveAll(Iterable<S> iterable) {
        return testMessageDao.saveAll(iterable);
    }

    @Override
    public Optional<TestMessage> findById(Long aLong) {
        return testMessageDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return testMessageDao.existsById(aLong);
    }

    @Override
    public void flush() {
        testMessageDao.flush();

    }

    @Override
    public <S extends TestMessage> S saveAndFlush(S s) {
        return testMessageDao.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<TestMessage> iterable) {
        testMessageDao.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        testMessageDao.deleteAllInBatch();

    }

    @Override
    public TestMessage getOne(Long aLong) {
        return testMessageDao.getOne(aLong);
    }

    @Override
    public <S extends TestMessage> Optional<S> findOne(Example<S> example) {
        return testMessageDao.findOne(example);
    }

    @Override
    public <S extends TestMessage> List<S> findAll(Example<S> example) {
        return testMessageDao.findAll(example);
    }

    @Override
    public <S extends TestMessage> List<S> findAll(Example<S> example, Sort sort) {
        return testMessageDao.findAll(example,sort);
    }

    @Override
    public <S extends TestMessage> Page<S> findAll(Example<S> example, Pageable pageable) {
        return testMessageDao.findAll(example,pageable);
    }

    @Override
    public <S extends TestMessage> long count(Example<S> example) {
        return testMessageDao.count();
    }

    @Override
    public <S extends TestMessage> boolean exists(Example<S> example) {
        return testMessageDao.exists(example);
    }
}
