package com.haotian.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.haotian.api.Entity.Answer;
import com.haotian.api.Entity.Paper;
import com.haotian.api.Entity.Question;
import com.haotian.api.Entity.Test;
import com.haotian.api.MasterDatabase.Dao.AnswerDao;
import com.haotian.api.MasterDatabase.Dao.TestDao;
import com.haotian.api.SecondaryDatabase.Dao.AnswerDao2;
import com.haotian.api.SecondaryDatabase.Dao.PaperDao2;
import com.haotian.api.SecondaryDatabase.Dao.QuestionDao2;
import com.haotian.api.SecondaryDatabase.Dao.TestDao2;
import com.haotian.consumer.Convenient.Problem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentC {

    @Reference
    private PaperDao2 paperDao2;
    @Reference
    private QuestionDao2 questionDao2;
    @Reference
    private TestDao testDao;
    @Reference
    private TestDao2 testDao2;
    @Reference
    private AnswerDao answerDao;
    @Reference
    private AnswerDao2 answerDao2;
    @RequestMapping("/toGetPaper") //考生查看考试列表
    public String getTest(){
        System.out.println("学生");
        return "student/Paper";
    }
    @RequestMapping("/toStudentTest")
    public String getStudentTest(){
        System.out.println("转到历史考试页面");
        return "student/StudentTest";
    }

    @RequestMapping("/studentGetPaper") //学生得到试卷列表
    @ResponseBody
    public List<Paper> getPaper() throws JsonProcessingException {
        System.out.println("得到试卷列表");
        List<Paper> paperList=paperDao2.findAllByTestIsApproved("是");
        return paperList;
    }
    @RequestMapping("/studentGetTest")//返回已完成考试列表
    @ResponseBody
    public List<Test> getStudentTestList(HttpSession httpSession)throws JsonProcessingException {

        Long account=Long.parseLong(httpSession.getAttribute("account").toString());
        System.out.println("答题人账号"+account);
        List<Test> testList=testDao2.findAllByTestRespondentID(account);
        System.out.println("得到已完成考试列表");
        return testList;//返回已完成考试列表
    }
    @RequestMapping("/studentGetTestResult")//返回已完成考试列表
    @ResponseBody
    public List<Test> getStudentTestResultList(HttpSession httpSession)throws JsonProcessingException {

        Long account=Long.parseLong(httpSession.getAttribute("account").toString());
        System.out.println("答题人账号"+account);
        List<Test>testList=testDao2.findAllByTestRespondentIDAndIsConsult(account,"是");//得到以批阅考试
        System.out.println("得到已完成考试列表");
        return testList;//返回已完成考试列表
    }
    @RequestMapping("/toStudentShowPaperContent")
    public String toStudentShowPaperContent(HttpServletRequest httpServletRequest, HttpSession httpSession){

        System.out.println("考卷ID"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "student/ShowPaperContent";
    }
    @RequestMapping("/toStudentShowTestContent")//转到历史考试详细内容页面
    public String toStudentShowTestContent(HttpServletRequest httpServletRequest, HttpSession httpSession){
        System.out.println("考试ID"+httpServletRequest.getParameter("testID"));
        httpSession.setAttribute("TestID",httpServletRequest.getParameter("testID"));
        return "student/ShowTestContent";
    }
    @RequestMapping("/toStudentShowTestResultContent")//转到历史考试详细内容页面
    public String toStudentShowTestResultContent(HttpServletRequest httpServletRequest, HttpSession httpSession){
        System.out.println("考试ID"+httpServletRequest.getParameter("testID"));
        httpSession.setAttribute("TestID",httpServletRequest.getParameter("testID"));
        return "student/ShowTestResultContent";
    }

    @RequestMapping("/StudentExamQuestion")  //显示当前考卷 所有的问题
    @ResponseBody  // 用于转换对象为json
    public List<Question> ExamQuestionByteacherid(HttpSession httpSession) throws JsonProcessingException {
        String testPaperID=httpSession.getAttribute("TestPaperID").toString();//得到考卷编号
        System.out.println("学生得到"+testPaperID);
        long testPaperIDl=Long.parseLong(testPaperID);//
        List<Question> questionList=questionDao2.findAllByTestPaperID(testPaperIDl);//得到这个考卷的所有题目
        return questionList;
    }
    @RequestMapping("/studentGetTestContent")//得到具体考试的内容和答案
    @ResponseBody
    public List<Problem> studentGetTestContent(HttpSession httpSession)throws JsonProcessingException {
        List<Answer>answerList=answerDao2.findAllByTestID(Long.parseLong(httpSession.getAttribute("TestID").toString()));
        List<Problem> problemList=new ArrayList<Problem>();
        for(int i=0;i<answerList.size();i++){
            Problem problem=new Problem();
            problem.setProblemAnswer(answerList.get(i).getTestQuestionEamineeAns());//得到问题答案
            long testQuestionID=answerList.get(i).getTestQuestionID();
            problem.setProblemContent(questionDao2.findById(testQuestionID).getTestQuestionContent());//得到问题内容
            problem.setScore(answerList.get(i).getTestQuestionEScore());//得到 学生得分
            System.out.println("问题内容"+problem.getProblemContent()+"问题答案"+problem.getProblemAnswer()+"问题得分"+problem.getScore());
            problemList.add(problem);//加入到队列中
        }
        return problemList;
    }

    @RequestMapping("/studentSaveTest")
    public String studentSaveTest(HttpServletRequest httpServletRequest, HttpSession httpSession){
        Long testPaperID=Long.parseLong(httpSession.getAttribute("TestPaperID").toString());//得到考卷ID
        Paper paper=paperDao2.findByTestPaperID(testPaperID);//得到考卷

        System.out.println("考卷ID"+testPaperID);
        System.out.println("交卷过程中");
        Long account=Long.parseLong(httpSession.getAttribute("account").toString());//答题人编号
//        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());//
        LocalDateTime dateTime = LocalDateTime.now();//获取当前时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");//格式化
        List<Question> questionList=questionDao2.findAllByTestPaperID(testPaperID);//得到考卷内容
        System.out.println("问题个数"+questionList.size());
        Test test=new Test();//新建考试
        test.setTestPaperID(testPaperID);//设定考卷ID
        test.setTestRespondentID(account);//答题人编号
        test.setTestTime(dateTime.format(formatter));//当前日期
        test.setIsConsult("否");//设定当前未批改
        test.setTestQuestionSetterID(paper.getTestQuestionSetterID());//设定出题人账号
        Test test1=testDao.save(test);
        System.out.println("考试保存成功"+test1.getTestID());
        for(int i=0;i<questionList.size();i++)
        {
            Question question=questionList.get(i);//得到具体问题
            String ans=httpServletRequest.getParameter(String.valueOf(question.getTestQuestionID()));//得到考生答案
            System.out.println("问题编号"+question.getTestQuestionID());
            System.out.println("考生答案"+ans);
            Answer answer=new Answer();//答案
            answer.setTestEamineeAnswerID(account);//写入考生编号
            answer.setTestQuestionID(question.getTestQuestionID());//写入题目编号
            answer.setTestQuestionEamineeAns(ans);//考生答案
            answer.setTestID(test1.getTestID());//得到考试编号
            answerDao.save(answer);//保存数据库中
            System.out.println("答案保存成功");
        }
        System.out.println("得到考卷");
        return "success.html";
    }
    @RequestMapping("/toStudentTestResult")
    public String studentTestResult(){
        return "student/ShowTestResult";
    }
}
