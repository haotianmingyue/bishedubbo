package com.haotian.provider2.serivce.impl.Seconde;

import com.alibaba.dubbo.config.annotation.Service;
import com.haotian.api.Entity.Question;
import com.haotian.api.SecondaryDatabase.Dao.QuestionDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionDao2S implements QuestionDao2 {
    @Autowired
    private QuestionDao2 questionDao2;

    @Override
    public List<Question> findAllByTestPaperID(long testPaperID) {
        return questionDao2.findAllByTestPaperID(testPaperID);
    }

    @Override
    public Question findById(long id) {
        return questionDao2.findById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionDao2.findAll();
    }

    @Override
    public List<Question> findAll(Sort sort) {
        return questionDao2.findAll(sort);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionDao2.findAll(pageable);
    }

    @Override
    public List<Question> findAllById(Iterable<Long> iterable) {
        return questionDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return questionDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        questionDao2.deleteById(aLong);

    }

    @Override
    public void delete(Question question) {
        questionDao2.delete(question);

    }

    @Override
    public void deleteAll(Iterable<? extends Question> iterable) {
        questionDao2.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        questionDao2.deleteAll();

    }

    @Override
    public <S extends Question> S save(S s) {
        return questionDao2.save(s);
    }

    @Override
    public <S extends Question> List<S> saveAll(Iterable<S> iterable) {
        return questionDao2.saveAll(iterable);
    }

    @Override
    public Optional<Question> findById(Long aLong) {
        return questionDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return questionDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        questionDao2.flush();

    }

    @Override
    public <S extends Question> S saveAndFlush(S s) {
        return questionDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Question> iterable) {
        questionDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        questionDao2.deleteAllInBatch();

    }

    @Override
    public Question getOne(Long aLong) {
        return questionDao2.getOne(aLong);
    }

    @Override
    public <S extends Question> Optional<S> findOne(Example<S> example) {
        return questionDao2.findOne(example);
    }

    @Override
    public <S extends Question> List<S> findAll(Example<S> example) {
        return questionDao2.findAll(example);
    }

    @Override
    public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
        return questionDao2.findAll(example,sort);
    }

    @Override
    public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
        return questionDao2.findAll(example,pageable);
    }

    @Override
    public <S extends Question> long count(Example<S> example) {
        return questionDao2.count(example);
    }

    @Override
    public <S extends Question> boolean exists(Example<S> example) {
        return questionDao2.exists(example);
    }

    @Override
    public Optional<Question> findOne(Specification<Question> specification) {
        return Optional.empty();
    }

    @Override
    public List<Question> findAll(Specification<Question> specification) {
        return questionDao2.findAll(specification);
    }

    @Override
    public Page<Question> findAll(Specification<Question> specification, Pageable pageable) {
        return questionDao2.findAll(specification,pageable);
    }

    @Override
    public List<Question> findAll(Specification<Question> specification, Sort sort) {
        return questionDao2.findAll(specification,sort);
    }

    @Override
    public long count(Specification<Question> specification) {
        return questionDao2.count();
    }
}
