package com.edumind.controller;

import com.edumind.common.AjaxResult;
import com.edumind.domain.StudentEvaluation;
import com.edumind.service.IStudentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation")
public class StudentEvaluationController {

    @Autowired
    private IStudentEvaluationService evaluationService;

    /**
     * 提交学生自我评价（由学生端调用）
     */
    @PostMapping("/submit")
    public AjaxResult submitEvaluation(@RequestBody @Validated StudentEvaluation evaluation) {
        evaluationService.submitEvaluation(evaluation);
        return AjaxResult.success("Submit successfully");
    }

    /**
     * 获取某个学生的最近 N 条评价（供教师查看）
     */
    @GetMapping("/recent/{studentId}")
    public AjaxResult getRecentEvaluations(
            @PathVariable String studentId,
            @RequestParam(defaultValue = "5") int limit) {
        List<StudentEvaluation> list = evaluationService.getRecentEvaluations(studentId,limit);
        return AjaxResult.success(list);
    }

    /**
     * 获取某个学生的全部评价（可用于心理状态分析）
     */
    @GetMapping("/all/{studentId}")
    public AjaxResult getAllEvaluations(@PathVariable String studentId,
                                        @RequestParam(defaultValue = "1") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        List<StudentEvaluation> evaluations = evaluationService.getAllEvaluations(studentId, page, size);
        return AjaxResult.success(evaluations);
    }
}