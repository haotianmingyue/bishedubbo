package com.haotian.provider2.serivce.impl.Seconde;

import com.alibaba.dubbo.config.annotation.Service;
import com.haotian.api.Entity.Paper;
import com.haotian.api.SecondaryDatabase.Dao.PaperDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class PaperDao2S implements PaperDao2 {
    @Autowired
    private  PaperDao2 paperDao2;
    @Override
    public List<Paper> findAll() {
        return paperDao2.findAll();
    }

    @Override
    public List<Paper> findAll(Sort sort) {
        return paperDao2.findAll(sort);
    }

    @Override
    public Page<Paper> findAll(Pageable pageable) {
        return paperDao2.findAll(pageable);
    }

    @Override
    public List<Paper> findAllById(Iterable<Long> iterable) {
        return paperDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return paperDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        paperDao2.deleteById(aLong);

    }

    @Override
    public void delete(Paper paper) {
        paperDao2.delete(paper);

    }

    @Override
    public void deleteAll(Iterable<? extends Paper> iterable) {
        paperDao2.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        paperDao2.deleteAll();

    }

    @Override
    public <S extends Paper> S save(S s) {
        return paperDao2.save(s);
    }

    @Override
    public <S extends Paper> List<S> saveAll(Iterable<S> iterable) {
        return paperDao2.saveAll(iterable);
    }

    @Override
    public Optional<Paper> findById(Long aLong) {
        return paperDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return paperDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        paperDao2.flush();

    }

    @Override
    public <S extends Paper> S saveAndFlush(S s) {
        return paperDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Paper> iterable) {
        paperDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        paperDao2.deleteAllInBatch();

    }

    @Override
    public Paper getOne(Long aLong) {
        return paperDao2.getOne(aLong);
    }

    @Override
    public <S extends Paper> Optional<S> findOne(Example<S> example) {
        return paperDao2.findOne(example);
    }

    @Override
    public <S extends Paper> List<S> findAll(Example<S> example) {
        return paperDao2.findAll(example);
    }

    @Override
    public <S extends Paper> List<S> findAll(Example<S> example, Sort sort) {
        return paperDao2.findAll(example,sort);
    }

    @Override
    public <S extends Paper> Page<S> findAll(Example<S> example, Pageable pageable) {
        return paperDao2.findAll(example,pageable);
    }

    @Override
    public <S extends Paper> long count(Example<S> example) {
        return paperDao2.count(example);
    }

    @Override
    public <S extends Paper> boolean exists(Example<S> example) {
        return paperDao2.exists(example);
    }

    @Override
    public List<Paper> findAllByTestQuestionSetterID(long testQuestionSetterID) {
        return paperDao2.findAllByTestQuestionSetterID(testQuestionSetterID);
    }

    @Override
    public List<Paper> findAllByTestIsApproved(String isApproved) {
        return paperDao2.findAllByTestIsApproved(isApproved);
    }

    @Override
    public Paper findByTestPaperID(Long testPaperID) {
        return paperDao2.findByTestPaperID(testPaperID);
    }
}
