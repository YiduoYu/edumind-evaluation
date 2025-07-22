package com.edumind.service.Impl;

import com.edumind.domain.StudentEvaluation;
import com.edumind.mapper.StudentEvaluationMapper;
//import com.edumind.util.AIAnalysisUtil;
import com.edumind.service.IStudentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentEvaluationServiceImpl implements IStudentEvaluationService {

    @Autowired
    private StudentEvaluationMapper evaluationMapper;

    @Override
    public void submitEvaluation(StudentEvaluation evaluation) {
        //1. 调用 AI 进行分析
//        var analysisResult = AIAnalysisUtil.analyzeSentiment(evaluation.getContent());
//
//        evaluation.setSentiment(analysisResult.getSentiment());
//        evaluation.setSentimentScore(analysisResult.getScore());
        evaluation.setCreateTime(LocalDateTime.now());

//        // 2. 判断是否连续两次为负面情绪
//        List<StudentEvaluation> recent = evaluationMapper.selectRecentEvaluations(evaluation.getStudentId(), 1);
//        boolean lastNegative = recent.stream().anyMatch(e -> "negative".equalsIgnoreCase(e.getSentiment()));
//        boolean currentNegative = "negative".equalsIgnoreCase(evaluation.getSentiment());
//
//        evaluation.setWarningTriggered(lastNegative && currentNegative);

        // 3. 入库
       evaluationMapper.insertEvaluation(evaluation);

        // 4. 可扩展：如果触发预警，发邮件/通知教授（后续实现）
    }

    @Override
    public List<StudentEvaluation> getRecentEvaluations(Long studentId, int limit) {
        return evaluationMapper.selectRecentEvaluations(studentId, limit);
    }

    @Override
    public List<StudentEvaluation> getAllEvaluations(Long studentId) {
        return evaluationMapper.selectAllEvaluations(studentId);
    }
}