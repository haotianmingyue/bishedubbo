package com.haotian.provider2.serivce.impl.Master;

import com.alibaba.dubbo.config.annotation.Service;
import com.haotian.api.Entity.Question;
import com.haotian.api.MasterDatabase.Dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionDaoS implements QuestionDao {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> findAllByTestPaperID(long testPaperID) {
        return questionDao.findAllByTestPaperID(testPaperID);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public List<Question> findAll(Sort sort) {
        return questionDao.findAll(sort);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionDao.findAll(pageable);
    }

    @Override
    public List<Question> findAllById(Iterable<Long> iterable) {
        return questionDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return questionDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        questionDao.deleteById(aLong);

    }

    @Override
    public void delete(Question question) {
        questionDao.delete(question);

    }

    @Override
    public void deleteAll(Iterable<? extends Question> iterable) {
        questionDao.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        questionDao.deleteAll();

    }

    @Override
    public <S extends Question> S save(S s) {
        return questionDao.save(s);
    }

    @Override
    public <S extends Question> List<S> saveAll(Iterable<S> iterable) {
        return questionDao.saveAll(iterable);
    }

    @Override
    public Optional<Question> findById(Long aLong) {
        return questionDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return questionDao.existsById(aLong);
    }

    @Override
    public void flush() {
        questionDao.flush();

    }

    @Override
    public <S extends Question> S saveAndFlush(S s) {
        return questionDao.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Question> iterable) {
        questionDao.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        questionDao.deleteAllInBatch();

    }

    @Override
    public Question getOne(Long aLong) {
        return questionDao.getOne(aLong);
    }

    @Override
    public <S extends Question> Optional<S> findOne(Example<S> example) {
        return questionDao.findOne(example);
    }

    @Override
    public <S extends Question> List<S> findAll(Example<S> example) {
        return questionDao.findAll(example);
    }

    @Override
    public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
        return questionDao.findAll(example,sort);
    }

    @Override
    public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
        return questionDao.findAll(example,pageable);
    }

    @Override
    public <S extends Question> long count(Example<S> example) {
        return questionDao.count(example);
    }

    @Override
    public <S extends Question> boolean exists(Example<S> example) {
        return questionDao.exists(example);
    }
}
