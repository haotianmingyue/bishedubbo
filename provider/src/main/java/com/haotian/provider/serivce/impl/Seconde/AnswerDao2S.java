package com.haotian.provider.serivce.impl.Seconde;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Answer;
import com.haotian.api.SecondaryDatabase.Dao.AnswerDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;



@Service
public class AnswerDao2S implements AnswerDao2 {
    @Autowired
    private  AnswerDao2 answerDao2;
    @Override
    public List<Answer> findAll() {
        return answerDao2.findAll();
    }

    @Override
    public List<Answer> findAll(Sort sort) {
        return answerDao2.findAll(sort);
    }

    @Override
    public Page<Answer> findAll(Pageable pageable) {
        return answerDao2.findAll(pageable);
    }

    @Override
    public List<Answer> findAllById(Iterable<Long> iterable) {
        return answerDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return answerDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        answerDao2.deleteById(aLong);

    }

    @Override
    public void delete(Answer answer) {
        answerDao2.delete(answer);

    }

    @Override
    public void deleteAll(Iterable<? extends Answer> iterable) {

    }

    @Override
    public void deleteAll() {
        answerDao2.deleteAll();

    }

    @Override
    public <S extends Answer> S save(S s) {
        return answerDao2.save(s);
    }

    @Override
    public <S extends Answer> List<S> saveAll(Iterable<S> iterable) {
        return answerDao2.saveAll(iterable);
    }

    @Override
    public Optional<Answer> findById(Long aLong) {
        return answerDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return answerDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        answerDao2.flush();

    }

    @Override
    public <S extends Answer> S saveAndFlush(S s) {
        return answerDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Answer> iterable) {
        answerDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        answerDao2.deleteAllInBatch();

    }

    @Override
    public Answer getOne(Long aLong) {
        return answerDao2.getOne(aLong);
    }

    @Override
    public <S extends Answer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Answer> List<S> findAll(Example<S> example) {
        return answerDao2.findAll(example);
    }

    @Override
    public <S extends Answer> List<S> findAll(Example<S> example, Sort sort) {
        return answerDao2.findAll(example,sort);
    }

    @Override
    public <S extends Answer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return answerDao2.findAll(example,pageable);
    }

    @Override
    public <S extends Answer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Answer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public List<Answer> findAllByTestID(long testid) {
        return answerDao2.findAllByTestID(testid);
    }
}
