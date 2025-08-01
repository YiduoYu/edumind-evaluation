package com.edumind.mapper;

import com.edumind.domain.StudentEvaluation;
import com.edumind.util.EvaluationTrendPoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentEvaluationMapper {

    void insertEvaluation(StudentEvaluation evaluation);

    List<StudentEvaluation> selectRecentEvaluations(@Param("studentId") String studentId,
                                                    @Param("limit") int limit);

    List<StudentEvaluation> selectAllEvaluations(@Param("studentId") String studentId);

    List<StudentEvaluation> selectByContentAndStudent(@Param("studentId") String studentId,
                                                      @Param("content") String content);

    List<StudentEvaluation> selectTodayByStudent(@Param("studentId") String studentId);

    List<StudentEvaluation> selectWarnings();

    List<EvaluationTrendPoint> selectTrendPointsByStudent(String studentId);
}