package com.haotian.provider2.serivce.impl.Seconde;

import com.alibaba.dubbo.config.annotation.Service;
import com.haotian.api.Entity.Perinformation;
import com.haotian.api.SecondaryDatabase.Dao.PerinformationDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class PerinformationDao2S implements PerinformationDao2 {
    @Autowired
    private  PerinformationDao2 perinformationDao2;
    @Override
    public List<Perinformation> findAll() {
        return perinformationDao2.findAll();
    }

    @Override
    public List<Perinformation> findAll(Sort sort) {
        return perinformationDao2.findAll(sort);
    }

    @Override
    public Page<Perinformation> findAll(Pageable pageable) {
        return perinformationDao2.findAll(pageable);
    }

    @Override
    public List<Perinformation> findAllById(Iterable<Long> iterable) {
        return perinformationDao2.findAllById(iterable);
    }

    @Override
    public long count() {
        return perinformationDao2.count();
    }

    @Override
    public void deleteById(Long aLong) {
        perinformationDao2.deleteById(aLong);

    }

    @Override
    public void delete(Perinformation perinformation) {
        perinformationDao2.delete(perinformation);

    }

    @Override
    public void deleteAll(Iterable<? extends Perinformation> iterable) {
        perinformationDao2.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        perinformationDao2.deleteAll();

    }

    @Override
    public <S extends Perinformation> S save(S s) {
        return perinformationDao2.save(s);
    }

    @Override
    public <S extends Perinformation> List<S> saveAll(Iterable<S> iterable) {
        return perinformationDao2.saveAll(iterable);
    }

    @Override
    public Optional<Perinformation> findById(Long aLong) {
        return perinformationDao2.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return perinformationDao2.existsById(aLong);
    }

    @Override
    public void flush() {
        perinformationDao2.flush();

    }

    @Override
    public <S extends Perinformation> S saveAndFlush(S s) {
        return perinformationDao2.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Perinformation> iterable) {
        perinformationDao2.deleteInBatch(iterable);

    }

    @Override
    public void deleteAllInBatch() {
        perinformationDao2.deleteAllInBatch();

    }

    @Override
    public Perinformation getOne(Long aLong) {
        return perinformationDao2.getOne(aLong);
    }

    @Override
    public <S extends Perinformation> Optional<S> findOne(Example<S> example) {
        return perinformationDao2.findOne(example);
    }

    @Override
    public <S extends Perinformation> List<S> findAll(Example<S> example) {
        return perinformationDao2.findAll(example);
    }

    @Override
    public <S extends Perinformation> List<S> findAll(Example<S> example, Sort sort) {
        return perinformationDao2.findAll(example,sort);
    }

    @Override
    public <S extends Perinformation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return perinformationDao2.findAll(example,pageable);
    }

    @Override
    public <S extends Perinformation> long count(Example<S> example) {
        return perinformationDao2.count(example);
    }

    @Override
    public <S extends Perinformation> boolean exists(Example<S> example) {
        return perinformationDao2.exists(example);
    }

    @Override
    public Perinformation findByUserID(long userID) {
        return perinformationDao2.findByUserID(userID);
    }

    @Override
    public Perinformation findByUserEmail(String userEmali) {
        return perinformationDao2.findByUserEmail(userEmali);
    }
}
