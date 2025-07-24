package com.edumind.service.Impl;

import com.edumind.config.BaiduNlpService;
import com.edumind.domain.SentimentResult;
import com.edumind.domain.Student;
import com.edumind.domain.StudentEvaluation;
import com.edumind.mapper.StudentEvaluationMapper;
import com.edumind.mapper.StudentMapper;
import com.edumind.service.IStudentEvaluationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentEvaluationServiceImpl implements IStudentEvaluationService {

    @Autowired
    private StudentEvaluationMapper evaluationMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private BaiduNlpService baiduNlpService;

    @Override
    public void submitEvaluation(StudentEvaluation evaluation) {

        //studentID合法性检查
        Student student = studentMapper.selectStudentByStudentId(evaluation.getStudentId());
        if (student == null) {
            throw new RuntimeException("Invalid Student ID, the student does not exist");
        }


        //每日每个学生只能提交一次
        List<StudentEvaluation> todaySubmissions = evaluationMapper.selectTodayByStudent(evaluation.getStudentId());
        if(!todaySubmissions.isEmpty()){
            throw new RuntimeException("You can only submit one review per day");
        }

        //判断是否为重复提交内容
        List<StudentEvaluation> sameContent = evaluationMapper.selectByContentAndStudent(evaluation.getStudentId(),evaluation.getContent());
        if(!sameContent.isEmpty()){
            throw new RuntimeException("Please don't submit the same content of review repeatedly");
        }
        //2. 时间戳补充
        evaluation.setCreateTime(LocalDateTime.now());


        //1. 调用 AI 进行分析
        SentimentResult analysisResult = BaiduNlpService.analyzeSentiment(evaluation.getContent());
        evaluation.setSentiment(analysisResult.getSentiment());
        evaluation.setSentimentScore(analysisResult.getScore());
        evaluation.setCreateTime(LocalDateTime.now());

        // 2. 判断是否连续两次为负面情绪
        List<StudentEvaluation> recent = evaluationMapper.selectRecentEvaluations(evaluation.getStudentId(), 1);
        boolean lastNegative = recent.stream().anyMatch(e -> "negative".equalsIgnoreCase(e.getSentiment()));
        boolean currentNegative = "negative".equalsIgnoreCase(evaluation.getSentiment());

        evaluation.setWarningTriggered(lastNegative && currentNegative);

        // 3. 入库
        evaluationMapper.insertEvaluation(evaluation);

        // 4. 可扩展：如果触发预警，发邮件/通知教授（后续实现）
    }


    @Override
    public List<StudentEvaluation> getRecentEvaluations(String studentId, int limit) {
        return evaluationMapper.selectRecentEvaluations(studentId, limit);
    }

    @Override
    public List<StudentEvaluation> getAllEvaluations(String studentId, int page, int size) {
        PageHelper.startPage(page, size); // 启用分页
        return evaluationMapper.selectAllEvaluations(studentId);
    }
}