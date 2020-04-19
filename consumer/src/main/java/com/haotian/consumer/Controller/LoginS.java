package com.haotian.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.haotian.api.Entity.Account;
import com.haotian.api.SecondaryDatabase.Dao.AccountDao2;
import com.haotian.consumer.Component.RedisUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//import com.haotian.demo.Test.AccountServiceimpl;

@Controller
public class LoginS {
    @Reference
    private AccountDao2 accountDao;
//    private AccountServiceimpl accountDao;
    @Resource
    private RedisUtil redisUtil;
    private Account account;
    @PostMapping("/LoginS")
//    @CachePut(value = "account", key = "#id")
    public String logins(HttpServletRequest request, HttpSession httpSession){
        String accounts=request.getParameter("account");
        System.out.println("LoginS"+accounts);
        long accountl=Long.parseLong(accounts);
        System.out.println(accountl);
//        List<Object> papers=  redisUtil.lGet("testQuestionSetterID223456",0,-1);
//        System.out.println(papers.size());
        if(redisUtil.get(accounts)==null){
            account=accountDao.findById(accountl);  //写入redis缓存
            redisUtil.set(accounts,account);
            System.out.println("第一次查询数据库");
        }
        else{
            account= (Account) redisUtil.get(accounts);
            System.out.println("从缓存中的到数据");
        }
//        account=accountDao.findById(accountl);
        if(account.getUserPass().equals(request.getParameter("password")))
        {
            if(account.getUserRole().equals("1")){//管理员主页
                httpSession.setAttribute("account",accounts);
                return "admin/adminindex.html";
            }
            if(account.getUserRole().equals("2")){
                httpSession.setAttribute("account",accounts);
                System.out.println(httpSession.getAttribute("account"));
                return "teacher/teaindex";//教师登录主页
            }
            if(account.getUserRole().equals("3")){
                httpSession.setAttribute("account",accounts);
                System.out.println(httpSession.getAttribute("account"));
                return "student/stuindex.html";
            }
            else{
                return "error.html";
            }
        }
        else{
            return "error.html";
        }

        }
//    @Cacheable(value = "account",key="#result.userID")
//    public Account getAccount(long id){
//        System.out.println("查询数据库");
//        return accountDao.findById(id);
//    }


}

