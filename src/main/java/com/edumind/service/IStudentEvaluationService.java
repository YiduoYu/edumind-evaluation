package com.edumind.service;


import com.edumind.domain.StudentEvaluation;
import com.edumind.util.EvaluationTrendPoint;

import java.util.List;

public interface IStudentEvaluationService {

    // 提交评价并执行情绪分析
    void submitEvaluation(StudentEvaluation evaluation);

    // 获取某学生最近的 N 次评价
    List<StudentEvaluation> getRecentEvaluations(String studentId, int limit);

    // 获取某学生的所有历史评价
    List<StudentEvaluation> getAllEvaluations(String studentId, int page, int size);

    List<StudentEvaluation> getWarnings(int page, int size);

    List<EvaluationTrendPoint> getTrendPoints(String studentId);
}