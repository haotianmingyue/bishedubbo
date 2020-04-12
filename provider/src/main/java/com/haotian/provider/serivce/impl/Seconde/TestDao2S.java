package com.haotian.provider.serivce.impl.Seconde;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Test;
import com.haotian.api.SecondaryDatabase.Dao.TestDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class TestDao2S implements TestDao2 {

    @Autowired
    private TestDao2 testDao2;

    @Override
    public List<Test> findAll() {
        return testDao2.findAll();
    }

    @Override
    public List<Test> findAll(Sort sort) {
        return testDao2.findAll(sort);
    }

    @Override
    public Page<Test> findAll(Pageable pageable) {
        return testDao2.findAll(pageable);
    }

    @Override
    public List<Test> findAllById(Iterable<Long> iterable) {
        return testDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return testDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        testDao2.deleteById(aLong);

    }

    @Override
    public void delete(Test test) {

        testDao2.delete(test);
    }

    @Override
    public void deleteAll(Iterable<? extends Test> iterable) {

        testDao2.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {

        testDao2.deleteAll();
    }

    @Override
    public <S extends Test> S save(S s) {
        return testDao2.save(s);
    }

    @Override
    public <S extends Test> List<S> saveAll(Iterable<S> iterable) {
        return testDao2.saveAll(iterable);
    }

    @Override
    public Optional<Test> findById(Long aLong) {
        return testDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return testDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        testDao2.flush();

    }

    @Override
    public <S extends Test> S saveAndFlush(S s) {
        return testDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Test> iterable) {
        testDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        testDao2.deleteAllInBatch();

    }

    @Override
    public Test getOne(Long aLong) {
        return testDao2.getOne(aLong);
    }

    @Override
    public <S extends Test> Optional<S> findOne(Example<S> example) {
        return testDao2.findOne(example);
    }

    @Override
    public <S extends Test> List<S> findAll(Example<S> example) {
        return testDao2.findAll(example);
    }

    @Override
    public <S extends Test> List<S> findAll(Example<S> example, Sort sort) {
        return testDao2.findAll(example,sort);
    }

    @Override
    public <S extends Test> Page<S> findAll(Example<S> example, Pageable pageable) {
        return testDao2.findAll(example,pageable);
    }

    @Override
    public <S extends Test> long count(Example<S> example) {
        return testDao2.count();
    }

    @Override
    public <S extends Test> boolean exists(Example<S> example) {
        return testDao2.exists(example);
    }

    @Override
    public List<Test> findAllByTestRespondentID(long testRespondentID) {
        return testDao2.findAllByTestRespondentID(testRespondentID);
    }

    @Override
    public List<Test> findAllByTestRespondentIDAndIsConsult(long testRespondentID, String isConsult) {
        return testDao2.findAllByTestRespondentIDAndIsConsult(testRespondentID,isConsult);
    }

    @Override
    public List<Test> findAllByTestQuestionSetterIDAndIsConsult(long testSetterID, String isConslut) {
        return testDao2.findAllByTestQuestionSetterIDAndIsConsult(testSetterID,isConslut);
    }

    @Override
    public Test findByTestID(long testID) {
        return testDao2.findByTestID(testID);
    }
}
