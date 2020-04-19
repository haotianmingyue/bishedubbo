package com.haotian.consumer.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.api.Entity.Account;
import com.haotian.api.SecondaryDatabase.Dao.AccountDao2;
import com.haotian.consumer.Component.RedisUtil;
import com.haotian.consumer.Component.RedisUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisUtils redisUtils;
    @Reference
    private AccountDao2 accountDao;
    @Resource
    private RedisUtil redisU;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 插入缓存数据
     */
    @Test
    public void set() throws JsonProcessingException {
//        redisUtils.set("123456",accountDao.findById(123456));
//        redisU.set("123456",accountDao.findById(123456));
//        redisU.lSet("account",accountDao.findAll(),50000);
//        System.out.println(redisU.get("123456"));
//        System.out.println(redisU.lGet("account",0,-1));
//        List<Account> list=(List<Account>)redisU.lGet("account",0,-1);
//        System.out.println(list.get(0).toString());
//        redisTemplate.opsForValue().set("account1",accountDao.findById(123456));
//        List<Account>accounts=(List<Account>) redisU.lGet("account",0,-1);
//        System.out.println(redisU.hget("123456","userPass"));
//        Account account= (Account) redisTemplate.opsForValue().get("account1");
//        redisTemplate.opsForList().set("accountlist",500,accountDao.findAll());
//        redisU.set("account",accountDao.findById(223456));
//        redisTemplate.opsForValue().set("accountlist",accountDao.findAll());

        List<Account>accountList=accountDao.findAll();
        for(int i=0;i<accountList.size();i++){
            redisU.lSet("accounts",accountList.get(i));
        }
        List<Object> accounts=redisU.lGet("accounts",0,-1);
        System.out.println(accounts.size());
        Account account=(Account)accounts.get(0);
        System.out.println(account.getUserID());
        List<Object> papers=redisU.lGet("testQuestionSetterID223456",0,-1);
        System.out.println(papers.size());

    }

    /**
     * 读取缓存数据
     */
    @Test
    public void get() {
        String value = redisUtils.get("redis_key");
        System.out.println(value);
    }
    @Test
    public void delete(){
        redisUtils.delete("redis_key");
    }

}
