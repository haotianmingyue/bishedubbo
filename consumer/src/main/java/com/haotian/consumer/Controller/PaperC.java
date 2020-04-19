package com.haotian.consumer.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haotian.api.Entity.*;
import com.haotian.api.MasterDatabase.Dao.AnswerDao;
import com.haotian.api.MasterDatabase.Dao.PaperDao;
import com.haotian.api.MasterDatabase.Dao.QuestionDao;
import com.haotian.api.MasterDatabase.Dao.TestDao;
import com.haotian.api.SecondaryDatabase.Dao.AnswerDao2;
import com.haotian.api.SecondaryDatabase.Dao.PaperDao2;
import com.haotian.api.SecondaryDatabase.Dao.QuestionDao2;
import com.haotian.api.SecondaryDatabase.Dao.TestDao2;
import com.haotian.consumer.Component.RedisUtil;
import com.haotian.consumer.Convenient.QuestionAndAnswer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PaperC {
    int state=0;
    @Reference
    private QuestionDao questionDao;
    @Reference
    private PaperDao paperDao;
    @Reference
    private QuestionDao2 questionDao2;//从数据库读
    @Reference
    private PaperDao2 paperDao2;//从数据中读考卷
    @Reference
    private TestDao2 testDao2;
    @Reference
    private TestDao testDao;
    @Reference
    private AnswerDao2 answerDao2;
    @Reference
    private AnswerDao answerDao;
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private Map<String,Object> result = new HashMap<String,Object>();

    @RequestMapping("/toExam")  //新建试卷
    public String examquestion(HttpSession httpSession){
        LocalDateTime dateTime = LocalDateTime.now();//获取当前时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");//格式化
        Paper paper=new Paper();
        paper.setTestPaperTime(dateTime.format(formatter));
        String account=httpSession.getAttribute("account").toString();
//        System.out.println("setTestQuestionSetterID"+account);
        long accountl=Long.parseLong(account);
        paper.setTestQuestionSetterID(accountl);
        paper.setTestPaperTotalTime("60");//默认60分钟
        paper.setTestIsApproved("否");//默认未通过审核
        System.out.println(paper.getTestPaperTime()+paper.getTestPaperTotalTime());
        Paper paper1= paperDao.save(paper);//存入Paper数据库中
        httpSession.setAttribute("TestPaperID",paper1.getTestPaperID());
//        System.out.println("TestPaperID"+paper1.getTestPaperID());
        return "teacher/Exam";
    }
    @RequestMapping("/toBeMarked")
    public String toBemarked(){
        return "teacher/Test";
    }

    @RequestMapping("/saveExamQuestions")
    @ResponseBody
    public Map<String,Object> saveExamQuestions(Question question, HttpServletRequest request, HttpSession httpSession, Integer testQuestionID){
        try {
            System.out.println("数据库添加完毕");
            question.setTestPaperID(Long.parseLong(httpSession.getAttribute("TestPaperID").toString()));
            question.setTestQuestionContent(question.getTestQuestionContent());
            question.setTestQuestionTrueAns(question.getTestQuestionTrueAns());
            question.setTestQuestionScore(question.getTestQuestionScore());
            questionDao.save(question);//主数据库存
            state=1;
            if(question.getTestQuestionContent().equals("null"))
                result.put("success",false);
            else
                result.put("success", true);
        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;

    }

    @RequestMapping("/updateExamQuestions")
    @ResponseBody
    public Map<String,Object> updateExamQuestions(Question question, HttpServletRequest request, HttpSession httpSession, Integer testQuestionID){
        try {

//            System.out.println("testQuestionid"+question.getTestQuestionID());
            Question question1=new Question();
            question1.setTestPaperID(Long.parseLong(httpSession.getAttribute("TestPaperID").toString()));
            question1.setTestQuestionContent(question.getTestQuestionContent());
            question1.setTestQuestionTrueAns(question.getTestQuestionTrueAns());
            question1.setTestQuestionScore(question.getTestQuestionScore());
            questionDao.deleteById(question.getTestQuestionID());//删除前一个
            questionDao.save(question1);//新加数据
            if(question.getTestQuestionContent().equals("null"))
                result.put("success",false);
            else
                result.put("success", true);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;

    }
    @RequestMapping("/getPaper") //得到历史试卷
    @ResponseBody
    public List<Paper> getPaper(HttpSession httpSession) throws JsonProcessingException {
        String account=httpSession.getAttribute("account").toString();//得到账号
        long testQuestionSetterID=Long.parseLong(account);
        System.out.println("得到出题人账号"+testQuestionSetterID);
        List<Paper> paperList=new ArrayList<>();
//        System.out.println(redisUtil.lGet("testQuestionSetterID"+account,0,-1).equals("[]"));
        System.out.println(redisUtil.lGet("testQuestionSetterID"+account,0,-1).size());
        if (redisUtil.lGet("testQuestionSetterID"+account,0,-1).size()==0){
             paperList=paperDao2.findAllByTestQuestionSetterID(testQuestionSetterID);
            for(int i=0;i<paperList.size();i++)//
            {
                redisUtil.lSet("testQuestionSetterID"+account,paperList.get(i));
            }
            System.out.println("得到历史考卷写入缓存");
        }
        else
        {
            List<Object> papers=  redisUtil.lGet("testQuestionSetterID"+account,0,-1);
            for(int i=0;i<papers.size();i++)
        {
            Paper paper= (Paper) papers.get(i);
            paperList.add(paper);
        }
            System.out.println("从缓存中读到的");
        }
//        List<Paper> paperList=paperDao2.findAllByTestQuestionSetterID(testQuestionSetterID);
//        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
//        System.out.println(mapper.writeValueAsString(paperList));
//        List<Object> papers=  redisUtil.lGet("testQuestionSetterID223456",0,-1);
//        System.out.println(papers.size());
//        if(redisUtil.lGet("testQuestionSetterID"+account,0,-1)==null)
//        {
//
//        }
//        for(int i=0;i<papers.size();i++)
//        {
//            System.out.println("i="+i);
//            Paper paper= (Paper) papers.get(i);
//            paperList.add(paper);
//        }
////
        return paperList;
    }
    @RequestMapping("/ExamQuestion")  //显示当前考卷 所有的问题
    @ResponseBody  // 用于转换对象为json
    public List<Question> ExamQuestionByteacherid(HttpSession httpSession, @RequestParam(value = "page")Integer page, @RequestParam(value = "rows")Integer size) throws JsonProcessingException, AWTException {
        String testPaperID=httpSession.getAttribute("TestPaperID").toString();//得到考卷编号
        long testPaperIDl=Long.parseLong(testPaperID);//
        System.out.println(testPaperIDl);
        //Page<Question> findAllByTestestPaperID(testPaperIDl,)
        System.out.println(testPaperIDl);
//        Timer timer = new Timer();// 实例化Timer类  //注意主从数据库中 刚在主数据库中写入数据，又在从数据库中读，可能会读不到.
//        List<Question> questionList=new ArrayList<>();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                System.out.println("退出");
//                this.cancel();
//            }
//        }, 5000);// 这里百毫秒
//        System.out.println("本程序存在5秒后自动退出");

        List<Question> questionList=questionDao.findAllByTestPaperID(testPaperIDl);//得到这个考卷的所有题目
//        List<Question> questionList=questionDao2.findAllByTestPaperID(testPaperIDl);//得到这个考卷的所有题目
        System.out.println("数据库刷新");
        System.out.println(questionList.size());
        return questionList;

        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        // 分页
//        questionDao2.findAll(new PageRequest(page,size));
//        List<Question> questionList =questionDao2.findAll();
//        ObjectMapper mapper=new ObjectMapper();//注意返回的名称是 userID 不是 UserID 搞不懂为什莫会变成小写
//        System.out.println(mapper.writeValueAsString(questionList));


    }
    @RequestMapping("/findExamQuestionsById")  //修改表格时的查找具体问题
    @ResponseBody
    public Question findExamQuestionsById(Integer testQuestionID){
        System.out.println("testQuestionID "+testQuestionID);

        Question question=questionDao2.findById(testQuestionID);
        return question;
    }

    @RequestMapping("/deleteTestQuestion") //删除问题
    @ResponseBody
    public Map<String,Object> delete(long testQuestionID){
        try {
//            System.out.println("idididiidididi"+testQuestionID);
            questionDao.deleteById(testQuestionID);
            //adminUserService.deleteLoginUser(id);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

//    @RequestMapping(value = "/displayAll",method = RequestMethod.GET)
//    public Map<String,java.lang.Object> findAllDepartments(@RequestParam(value = "page")Integer page, @RequestParam(value = "rows")Integer size){
//        Page<Question> list= questionDao2.findAllByTestPaperID(new PageRequest(page-1,size));
//        Map<String,java.lang.Object> map = new HashMap<String,java.lang.Object>();
////        int total = questionDao2.findAllByTestestPaperID().size();
////        map.put("total",total);
////        map.put("rows",list.getContent());
//        return map ;
//    }

    @RequestMapping("/toPaper")  //查询自己发布的考卷
    public String getPaper(){
        return "teacher/Paper";

    }
    @RequestMapping("/toShowPaperContent")//查看考卷详细信息
    public String showPaperContent(HttpServletRequest httpServletRequest, HttpSession httpSession){
        System.out.println("试卷编号"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "teacher/ShowPaperContent";
    }
    @RequestMapping("/toShowManagePaperContent")//管理员查看考卷详细信息
    public String showManagePaperContent(HttpServletRequest httpServletRequest, HttpSession httpSession){
        System.out.println("试卷编号"+httpServletRequest.getParameter("testPaperID"));
        httpSession.setAttribute("TestPaperID",httpServletRequest.getParameter("testPaperID"));
        return "admin/ShowPaperContent";
    }
    @RequestMapping("/toTeacherShowTestContent")//转到教师查看学生回答页面
    public String toTeacherShowTestContent(HttpSession httpSession, HttpServletRequest httpServletRequest){
        System.out.println("考试id"+httpServletRequest.getParameter("testID"));
        httpSession.setAttribute("TestID",httpServletRequest.getParameter("testID"));
        return "teacher/ShowTest";
    }
    @RequestMapping("/test")
    public  String test(){
        return "teacher/unuse.html";
    }
    @RequestMapping("/teacherGetTest")
    @ResponseBody
    public List<Test> teacherGetTest(HttpSession httpSession){
        Long account=Long.parseLong(httpSession.getAttribute("account").toString());
        List<Test>testList=testDao2.findAllByTestQuestionSetterIDAndIsConsult(account,"否");
        return  testList;
    }
    @RequestMapping("/teacherGetTestContent")
    @ResponseBody
    public List<QuestionAndAnswer> teacherGetTestContent(HttpSession httpSession){
        Long testID=Long.parseLong(httpSession.getAttribute("TestID").toString());
        System.out.println("考试idid"+testID);
        List<QuestionAndAnswer> questionAndAnswerList=new ArrayList<QuestionAndAnswer>();
        List<Answer> answerList=answerDao2.findAllByTestID(testID);
        for(int i=0;i<answerList.size();i++){
            QuestionAndAnswer questionAndAnswer=new QuestionAndAnswer();
            questionAndAnswer.setStudentAnswer(answerList.get(i).getTestQuestionEamineeAns());//得到答案
            questionAndAnswer.setQuestion(questionDao2.findById(answerList.get(i).getTestQuestionID()).getTestQuestionContent());//得到问题内容
            questionAndAnswer.setCorrect(questionDao2.findById(answerList.get(i).getTestQuestionID()).getTestQuestionTrueAns());//得到正确答案
            questionAndAnswer.setScore(questionDao2.findById(answerList.get(i).getTestQuestionID()).getTestQuestionScore());//得到题目分值
            questionAndAnswer.setQuestionID(questionDao2.findById(answerList.get(i).getTestQuestionID()).getTestQuestionID());//得到题目id
            questionAndAnswer.setAnswerID(answerList.get(i).getAnswerID());//答案编号
            questionAndAnswerList.add(questionAndAnswer);//添加到列表中
        }
        System.out.println("数据传输完毕");
        return questionAndAnswerList;
    }
    @RequestMapping("/teacherSaveTest")
    public String teacherSaveTest(HttpSession httpSession, HttpServletRequest httpServletRequest){
        long total=0;
        long testID=Long.parseLong(httpSession.getAttribute("TestID").toString());//得到考试编号
        List<Answer> answerList=answerDao2.findAllByTestID(testID);//得到这个考试的所有答案
        for(int i=0;i<answerList.size();i++){
            String score=httpServletRequest.getParameter(Long.toString(answerList.get(i).getAnswerID()));
            System.out.println("分数"+score);
            Answer answer=answerList.get(i);
            answer.setTestQuestionEScore(score);//设定得分
            answerDao.save(answer);//保存数据库
            total=total+Long.parseLong(score);//得分相加
        }
        Test test=testDao2.findByTestID(testID);
        test.setIsConsult("是");//设定已阅
        System.out.println("总分"+total);
        test.setTestTotalScore(Long.toString(total));
        testDao.save(test);//更新数据库
        return "success";
    }




}
