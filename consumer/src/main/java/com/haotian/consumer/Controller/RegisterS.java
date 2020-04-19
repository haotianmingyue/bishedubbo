package com.haotian.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.haotian.api.Entity.Account;
import com.haotian.api.MasterDatabase.Dao.AccountDao;
import com.haotian.api.SecondaryDatabase.Dao.AccountDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterS {
//
    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    @Autowired //自动注入了Config文件中的写的 Bean 主要作用是  隐藏名称
    private Queue queue;
    @Reference
    private AccountDao2 accountDao2;
    @Reference
    private AccountDao accountDao;
    private Map<String,Object> result = new HashMap<String,Object>();

    @PostMapping("/RegisterS")//注册学生账号
    public String register(HttpServletRequest request){
        Account account=new Account();
        account.setUserID(Long.parseLong(request.getParameter("account")));
        account.setUserPass(request.getParameter("password"));
        account.setUserRole("3");
        jmsTemplate.convertAndSend(queue,account);
        accountDao.save(account);
        return "index.html";
    }
    @RequestMapping("/manageadteacher")//得到教师账号
    @ResponseBody
    public List<Account> getTeacherAccount(HttpSession httpSession) throws JsonProcessingException {
       // System.out.println(httpSession.getAttribute("userRole3"));
        String userRole2=httpSession.getAttribute("userRole2").toString();
        String userRole3=httpSession.getAttribute("userRole3").toString();
        System.out.println(userRole2+userRole3);
        if(userRole2.equals("2")){
            List<Account> accountList=accountDao.findAllByUserRole("2");//查询所有账号  现在先从主数据中存 因为主从数据库有延迟 存了立马读 是读不到的
            return accountList;
        }
        else
        {
            //System.out.println("session"+httpSession.getAttribute("userRole3"));
            List<Account> accountList=accountDao.findAllByUserRole("3");//查询所有账号  现在先从主数据中存 因为主从数据库有延迟 存了立马读 是读不到的
            return accountList;
        }



    }

    @RequestMapping("/accountfindById")
    @ResponseBody
    public Account getAccount(HttpServletRequest httpServletRequest)throws JsonProcessingException {
        System.out.println(httpServletRequest.getParameter("userID"));
        long userID=Long.parseLong(httpServletRequest.getParameter("userID"));
        Account account=accountDao.findById(userID);
        return account;

    }
    @RequestMapping("/updateAccount")//修改密码
    @ResponseBody
    public Map<String,Object> updateAccount(HttpServletRequest httpServletRequest, HttpSession httpSession){
        try{
            long userID=Long.parseLong(httpServletRequest.getParameter("userID"));
            System.out.println("账号"+userID);
            accountDao.deleteById(userID);
            Account account=new Account();//新的账号
            account.setUserID(userID);
            account.setUserPass(httpServletRequest.getParameter("userPass"));
            if(httpSession.getAttribute("userRole3").equals("null"))
            account.setUserRole("2");
            else account.setUserRole("3");
            accountDao.save(account);//保存新的账号
            result.put("success", true);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;


    }



    @RequestMapping("/saveteacherAccount")
    @ResponseBody
    public Map<String,Object> saveExamQuestions(HttpServletRequest httpServletRequest, HttpSession httpSession){
        try {
            Account account=new Account();
            System.out.println("新建教师账号");


            long userID=Long.parseLong(httpServletRequest.getParameter("userID"));
            //System.out.println("账号"+Long.parseLong(httpServletRequest.getParameter("userID")));
            account.setUserID(userID);
            account.setUserPass(httpServletRequest.getParameter("userPass"));
            if(httpSession.getAttribute("userRole2").equals("null")){
                account.setUserRole("3");//设置身份//学生
            }
            else
            {
                System.out.println("新建教师账号1");
                account.setUserRole("2");//设置身份教师
            }
            if(accountDao2.findById(userID)!=null)
            {
                result.put("success",false);
                result.put("msg","账号已存在");
            }
            else{
                accountDao.save(account);//主数据库存
                //System.out.println("账号"+account.getUserID()+"密码"+account.getUserPass()+"身份"+account.getUserRole());
                System.out.println("数据库添加完毕");
                result.put("success", true);
            }

        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;

    }

    @RequestMapping("deleteAccount")
    @ResponseBody
    public Map<String,Object> deleteAccount(HttpServletRequest httpServletRequest){
        try{
            //System.out.println(httpServletRequest.getParameter("userID"));
            accountDao.deleteById(Long.parseLong(httpServletRequest.getParameter("userID")));
            result.put("success", true);

        }catch (Exception e){
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());

        }
        return result;

    }



}
