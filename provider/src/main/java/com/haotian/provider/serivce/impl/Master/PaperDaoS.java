package com.haotian.provider.serivce.impl.Master;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Paper;
import com.haotian.api.MasterDatabase.Dao.PaperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class PaperDaoS implements PaperDao {
    @Autowired
    private  PaperDao paperDao;
    @Override
    public void updateStateByMoney(Long testPaperID, String testIsApproved) {

    }

    @Override
    public Paper findByTestPaperID(long testPaperID) {
        return paperDao.findByTestPaperID(testPaperID);
    }

    @Override
    public List<Paper> findAll() {
        return paperDao.findAll();
    }

    @Override
    public List<Paper> findAll(Sort sort) {
        return paperDao.findAll(sort);
    }

    @Override
    public Page<Paper> findAll(Pageable pageable) {
        return paperDao.findAll(pageable);
    }

    @Override
    public List<Paper> findAllById(Iterable<Long> iterable) {
        return paperDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return paperDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        paperDao.deleteById(aLong);

    }

    @Override
    public void delete(Paper paper) {
        paperDao.delete(paper);

    }

    @Override
    public void deleteAll(Iterable<? extends Paper> iterable) {
        paperDao.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        paperDao.deleteAll();

    }

    @Override
    public <S extends Paper> S save(S s) {
        return paperDao.save(s);
    }

    @Override
    public <S extends Paper> List<S> saveAll(Iterable<S> iterable) {
        return paperDao.saveAll(iterable);
    }

    @Override
    public Optional<Paper> findById(Long aLong) {
        return paperDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return paperDao.existsById(aLong);
    }

    @Override
    public void flush() {
        paperDao.flush();

    }

    @Override
    public <S extends Paper> S saveAndFlush(S s) {
        return paperDao.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Paper> iterable) {
        paperDao.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        paperDao.deleteAllInBatch();

    }

    @Override
    public Paper getOne(Long aLong) {
        return paperDao.getOne(aLong);
    }

    @Override
    public <S extends Paper> Optional<S> findOne(Example<S> example) {
        return paperDao.findOne(example);
    }

    @Override
    public <S extends Paper> List<S> findAll(Example<S> example) {
        return paperDao.findAll(example);
    }

    @Override
    public <S extends Paper> List<S> findAll(Example<S> example, Sort sort) {
        return paperDao.findAll(example,sort);
    }

    @Override
    public <S extends Paper> Page<S> findAll(Example<S> example, Pageable pageable) {
        return paperDao.findAll(example,pageable);
    }

    @Override
    public <S extends Paper> long count(Example<S> example) {
        return paperDao.count(example);
    }

    @Override
    public <S extends Paper> boolean exists(Example<S> example) {
        return paperDao.exists(example);
    }
}
