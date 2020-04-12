package com.haotian.provider.serivce.impl.Master;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Answer;
import com.haotian.api.MasterDatabase.Dao.AnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerDaoS implements AnswerDao {
    @Autowired
    private  AnswerDao answerDao;
    @Override
    public List<Answer> findAll() {
        return answerDao.findAll();
    }

    @Override
    public List<Answer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Answer> findAll(Pageable pageable) {
        return answerDao.findAll(pageable);
    }

    @Override
    public List<Answer> findAllById(Iterable<Long> iterable) {
        return answerDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return answerDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        answerDao.deleteById(aLong);

    }

    @Override
    public void delete(Answer answer) {
        answerDao.delete(answer);

    }

    @Override
    public void deleteAll(Iterable<? extends Answer> iterable) {

    }

    @Override
    public void deleteAll() {
        answerDao.deleteAll();

    }

    @Override
    public <S extends Answer> S save(S s) {
        return answerDao.save(s);
    }

    @Override
    public <S extends Answer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Answer> findById(Long aLong) {
        return answerDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Answer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Answer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Answer getOne(Long aLong) {
        return answerDao.getOne(aLong);
    }

    @Override
    public <S extends Answer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Answer> List<S> findAll(Example<S> example) {
        return answerDao.findAll(example);
    }

    @Override
    public <S extends Answer> List<S> findAll(Example<S> example, Sort sort) {
        return answerDao.findAll(example,sort);
    }

    @Override
    public <S extends Answer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return answerDao.findAll(example,pageable);
    }

    @Override
    public <S extends Answer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Answer> boolean exists(Example<S> example) {
        return false;
    }
}
