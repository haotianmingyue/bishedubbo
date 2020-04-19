package com.haotian.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.haotian.api.Entity.Paper;
import com.haotian.api.Entity.TestMessage;
import com.haotian.api.MasterDatabase.Dao.TestMessageDao;
import com.haotian.api.SecondaryDatabase.Dao.PaperDao2;
import com.haotian.api.SecondaryDatabase.Dao.TestMessageDao2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageC {

    @Reference
    private TestMessageDao testMessageDao;

    @Reference
    private TestMessageDao2 testMessageDao2;
    @Reference
    private PaperDao2 paperDao2;
    private Map<String,Object> result = new HashMap<String,Object>();


    @RequestMapping("/saveMessage")
    @ResponseBody
    public Map<String,Object> saveMessage(HttpServletRequest request, HttpSession httpSession, Integer testQuestionID){
        try {
            TestMessage testMessage=new TestMessage();
            testMessage.setTestMessageContent(request.getParameter("testMessageContent"));//消息内容
            testMessage.setMessageIsConsult("否");//是否查阅
            testMessage.setMessageReviewerID(Long.parseLong(httpSession.getAttribute("account").toString()));//审核人id
            String testPaperID=httpSession.getAttribute("TestPaperID").toString();//得到考卷编号
            long testPaperIDl=Long.parseLong(testPaperID);//
//            System.out.println("试卷id"+testPaperIDl);
            testMessage.setTestPaperID(testPaperIDl);
//            System.out.println("消息内容"+request.getParameter("testMessageContent")+"\n 审核人id"+Long.parseLong(httpSession.getAttribute("account").toString()));
//            System.out.println("考卷编号"+testPaperIDl);
            Paper paper=paperDao2.findByTestPaperID(testPaperIDl);
//            System.out.println("出题人账号"+paper.getTestQuestionSetterID());
            testMessage.setTestGetterID(paper.getTestQuestionSetterID());//收件人账号
            testMessageDao.save(testMessage);//保存消息

            result.put("success", true);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;

    }

    @RequestMapping("/toTestMessage")//查看未读消息
    public String getMessage(){
        return "teacher/ShowMessage";
    }



    @RequestMapping("/getUnreadMessage") //得到历史试卷
    @ResponseBody
    public List<TestMessage> getPaper(HttpSession httpSession) throws JsonProcessingException {

        String account=httpSession.getAttribute("account").toString();//得到账号// 注意在一台电脑上同时运行管理员和教师时容易出错
        long testQuestionSetterID=Long.parseLong(account);
        System.out.println("得到出题人账号"+testQuestionSetterID);
        List<TestMessage> testMessageList =testMessageDao2.findAllByTestGetterIDAndAndMessageIsConsult(testQuestionSetterID,"否");
        return testMessageList;
    }
    @RequestMapping("/readMessage")
    @ResponseBody
    public void readMessage(HttpServletRequest httpServletRequest){

        System.out.println("消息已读"+"消息id"+httpServletRequest.getParameter("TestMessageID"));
        TestMessage testMessage=testMessageDao2.findByTestMessageID(Long.parseLong(httpServletRequest.getParameter("TestMessageID")));
        testMessage.setMessageIsConsult("是");
        testMessageDao.save(testMessage);//保存已读消息
    }

}
