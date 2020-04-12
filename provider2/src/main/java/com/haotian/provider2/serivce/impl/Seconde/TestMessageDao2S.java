package com.haotian.provider2.serivce.impl.Seconde;

import com.alibaba.dubbo.config.annotation.Service;
import com.haotian.api.Entity.TestMessage;
import com.haotian.api.SecondaryDatabase.Dao.TestMessageDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class TestMessageDao2S implements TestMessageDao2 {
    @Autowired
    private  TestMessageDao2 testMessageDao2;

    @Override
    public List<TestMessage> findAll() {
        return testMessageDao2.findAll();
    }

    @Override
    public List<TestMessage> findAll(Sort sort) {
        return testMessageDao2.findAll(sort);
    }

    @Override
    public Page<TestMessage> findAll(Pageable pageable) {
        return testMessageDao2.findAll(pageable);
    }

    @Override
    public List<TestMessage> findAllById(Iterable<Long> iterable) {
        return testMessageDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return testMessageDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        testMessageDao2.deleteById(aLong);

    }

    @Override
    public void delete(TestMessage testMessage) {
        testMessageDao2.delete(testMessage);

    }

    @Override
    public void deleteAll(Iterable<? extends TestMessage> iterable) {
        testMessageDao2.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        testMessageDao2.deleteAll();

    }

    @Override
    public <S extends TestMessage> S save(S s) {
        return testMessageDao2.save(s);
    }

    @Override
    public <S extends TestMessage> List<S> saveAll(Iterable<S> iterable) {
        return testMessageDao2.saveAll(iterable);
    }

    @Override
    public Optional<TestMessage> findById(Long aLong) {
        return testMessageDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return testMessageDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        testMessageDao2.flush();

    }

    @Override
    public <S extends TestMessage> S saveAndFlush(S s) {
        return testMessageDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<TestMessage> iterable) {
        testMessageDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        testMessageDao2.deleteAllInBatch();

    }

    @Override
    public TestMessage getOne(Long aLong) {
        return testMessageDao2.getOne(aLong);
    }

    @Override
    public <S extends TestMessage> Optional<S> findOne(Example<S> example) {
        return testMessageDao2.findOne(example);
    }

    @Override
    public <S extends TestMessage> List<S> findAll(Example<S> example) {
        return testMessageDao2.findAll(example);
    }

    @Override
    public <S extends TestMessage> List<S> findAll(Example<S> example, Sort sort) {
        return testMessageDao2.findAll(example,sort);
    }

    @Override
    public <S extends TestMessage> Page<S> findAll(Example<S> example, Pageable pageable) {
        return testMessageDao2.findAll(example,pageable);
    }

    @Override
    public <S extends TestMessage> long count(Example<S> example) {
        return testMessageDao2.count();
    }

    @Override
    public <S extends TestMessage> boolean exists(Example<S> example) {
        return testMessageDao2.exists(example);
    }

    @Override
    public List<TestMessage> findAllByTestGetterIDAndAndMessageIsConsult(long testGetterID, String messageIsConsult) {
        return testMessageDao2.findAllByTestGetterIDAndAndMessageIsConsult(testGetterID,messageIsConsult);
    }

    @Override
    public TestMessage findByTestMessageID(long testMessageId) {
        return testMessageDao2.findByTestMessageID(testMessageId);
    }
}
