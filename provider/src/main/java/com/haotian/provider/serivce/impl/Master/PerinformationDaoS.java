package com.haotian.provider.serivce.impl.Master;

import com.alibaba.dubbo.config.annotation.Service;

import com.haotian.api.Entity.Perinformation;
import com.haotian.api.MasterDatabase.Dao.PerinformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class PerinformationDaoS implements PerinformationDao {
    @Autowired
    private  PerinformationDao perinformationDao;
    @Override
    public List<Perinformation> findAll() {
        return perinformationDao.findAll();
    }

    @Override
    public List<Perinformation> findAll(Sort sort) {
        return perinformationDao.findAll(sort);
    }

    @Override
    public Page<Perinformation> findAll(Pageable pageable) {
        return perinformationDao.findAll(pageable);
    }

    @Override
    public List<Perinformation> findAllById(Iterable<Long> iterable) {
        return perinformationDao.findAllById(iterable);
    }

    @Override
    public long count() {
        return perinformationDao.count();
    }

    @Override
    public void deleteById(Long aLong) {
        perinformationDao.deleteById(aLong);

    }

    @Override
    public void delete(Perinformation perinformation) {
        perinformationDao.delete(perinformation);

    }

    @Override
    public void deleteAll(Iterable<? extends Perinformation> iterable) {
        perinformationDao.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        perinformationDao.deleteAll();

    }

    @Override
    public <S extends Perinformation> S save(S s) {
        return perinformationDao.save(s);
    }

    @Override
    public <S extends Perinformation> List<S> saveAll(Iterable<S> iterable) {
        return perinformationDao.saveAll(iterable);
    }

    @Override
    public Optional<Perinformation> findById(Long aLong) {
        return perinformationDao.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return perinformationDao.existsById(aLong);
    }

    @Override
    public void flush() {
        perinformationDao.flush();

    }

    @Override
    public <S extends Perinformation> S saveAndFlush(S s) {
        return perinformationDao.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Perinformation> iterable) {
        perinformationDao.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        perinformationDao.deleteAllInBatch();

    }

    @Override
    public Perinformation getOne(Long aLong) {
        return perinformationDao.getOne(aLong);
    }

    @Override
    public <S extends Perinformation> Optional<S> findOne(Example<S> example) {
        return perinformationDao.findOne(example);
    }

    @Override
    public <S extends Perinformation> List<S> findAll(Example<S> example) {
        return perinformationDao.findAll(example);
    }

    @Override
    public <S extends Perinformation> List<S> findAll(Example<S> example, Sort sort) {
        return perinformationDao.findAll(example,sort);
    }

    @Override
    public <S extends Perinformation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return perinformationDao.findAll(example,pageable);
    }

    @Override
    public <S extends Perinformation> long count(Example<S> example) {
        return perinformationDao.count(example);
    }

    @Override
    public <S extends Perinformation> boolean exists(Example<S> example) {
        return perinformationDao.exists(example);
    }
}
