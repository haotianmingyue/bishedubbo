package com.haotian.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.haotian.api.Email.IMailService;
import com.haotian.api.Entity.Account;
import com.haotian.api.Entity.Perinformation;
import com.haotian.api.MasterDatabase.Dao.AccountDao;
import com.haotian.api.MasterDatabase.Dao.PerinformationDao;
import com.haotian.api.SecondaryDatabase.Dao.AccountDao2;
import com.haotian.api.SecondaryDatabase.Dao.PerinformationDao2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class CommonC {
    @Reference
    private PerinformationDao2 perinformationDao2;
    @Reference
    private PerinformationDao perinformationDao;
    @Reference
    private IMailService mailService; //发邮件
    @Reference
    private AccountDao2 accountDao2;
    @Reference
    private AccountDao accountDao;

    @RequestMapping("/per")
    public String toPerInformation(){
        return "common/PerInformation";
    }
    @RequestMapping("/perinformationDo")
    public String perinformationDo(HttpServletRequest httpServletRequest, HttpSession httpSession){
        System.out.println("个人信息");
//        System.out.println(httpServletRequest.getParameter("userBirth"));
//        System.out.println(httpServletRequest.getParameter("userName"));
//        System.out.println(httpServletRequest.getParameter("userEmail"));
//        System.out.println(httpServletRequest.getParameter("userGender"));
        //Perinformation perinformation=new Perinformation(Long.parseLong(httpSession.getAttribute("account").toString()),httpServletRequest.getParameter("userName"),httpServletRequest.getParameter("userBirth"),httpServletRequest.getParameter("userEmail"),httpServletRequest.getParameter("userGender"));
        Perinformation perinformation=new Perinformation();
        perinformation.setUserID(Long.parseLong(httpSession.getAttribute("account").toString()));
        perinformation.setUserName(httpServletRequest.getParameter("userName"));
        perinformation.setUserBirth(httpServletRequest.getParameter("userBirth"));
        perinformation.setUserEmail(httpServletRequest.getParameter("userEmail"));
        perinformation.setUserGender(httpServletRequest.getParameter("userGender"));
        perinformationDao.save(perinformation);
        System.out.println("个人信息保存成功");
        return "success";
    }
    @RequestMapping("/getPerInformation")//个人信息管理
    @ResponseBody
    public Perinformation getPerInformation(HttpSession httpSession) throws JsonProcessingException {
        Long account=Long.parseLong(httpSession.getAttribute("account").toString());
        Perinformation perinformation=perinformationDao2.findByUserID(account);
//        System.out.println(perinformation.getUserName()+perinformation.getUserBirth());
//        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
//        System.out.println(mapper.writeValueAsString(perinformation));
        return perinformation;
    }
    @RequestMapping("/resetPass")//找回密码
    public void resetPass(HttpServletRequest httpServletRequest, HttpSession httpSession){
        String email=httpServletRequest.getParameter("email");
//        System.out.println(email);
        String ver=getRandomString(6);//生成验证码
//        System.out.println(ver);
        mailService.sendSimpleMail(email,"验证码","验证码是"+ver);
        httpSession.setAttribute("ver",ver);//保存验证码
//        mailService.sendHtmlMail(email,"主题：找回密码","<a href='www.baidu.com'>找回密码</h1>");
    }
    public static String getRandomString(int length){//生成随机字符串
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    @RequestMapping("/resetPassLogin")
    public String resetPassLogin(HttpServletRequest httpServletRequest, HttpSession httpSession){
        String email=httpServletRequest.getParameter("email");
//        System.out.println(email);
        String ver=httpServletRequest.getParameter("ver");
//        if(ver.equals(httpSession.getAttribute("ver")))
        if(true)
        {
            Perinformation perinformation=perinformationDao2.findByUserEmail(email);
            Account account=accountDao2.findById(perinformation.getUserID());
            if(account.getUserRole().equals("1")){//管理员主页
                httpSession.setAttribute("account",account.getUserID());
                return "admin/adminindex.html";
            }
            if(account.getUserRole().equals("2")){
                httpSession.setAttribute("account",account.getUserID());
//                System.out.println(httpSession.getAttribute("account"));
                return "teacher/teaindex";//教师登录主页
            }
            if(account.getUserRole().equals("3")){
                httpSession.setAttribute("account",account.getUserID());
//                System.out.println(httpSession.getAttribute("account"));
                return "student/stuindex.html";
            }
            System.out.println("成功");
        }
        else{
            System.out.println("失败");
        }
        return "index.html";

    }
    @RequestMapping("/toChangePass")
    public String toChangPass(){
        return "common/changePass";
    }
    @RequestMapping("/changePass")//修改密码
    public String changePass(HttpServletRequest httpServletRequest, HttpSession httpSession){
//        System.out.println(httpServletRequest.getParameter("password"));
        long userID=Long.parseLong(httpSession.getAttribute("account").toString());
        Account account=accountDao2.findById(userID);
        account.setUserPass(httpServletRequest.getParameter("password"));
        accountDao.save(account);//保存密码
//        System.out.println(userID);
        return "success";
    }

}
