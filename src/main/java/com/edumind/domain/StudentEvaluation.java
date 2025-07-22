package com.edumind.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StudentEvaluation {

    private Long id;                    // 评价ID（数据库主键）
    private Long studentId;             // 学生ID
    private String content;             // 自我评价内容
    private String sentiment;           // 情绪标签（positive / negative / neutral）
    private double sentimentScore;      // 情感强度分数（例如 -1 ~ 1）

    private boolean warningTriggered;   // 是否触发心理健康预警
    private LocalDateTime createTime;   // 提交时间
}