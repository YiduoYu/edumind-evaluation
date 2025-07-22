package com.edumind.mapper;

import com.edumind.domain.StudentEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentEvaluationMapper {

    int insertEvaluation(StudentEvaluation evaluation);

    List<StudentEvaluation> selectRecentEvaluations(@Param("studentId") Long studentId, @Param("limit") int limit);

    List<StudentEvaluation> selectAllEvaluations(Long studentId);
}