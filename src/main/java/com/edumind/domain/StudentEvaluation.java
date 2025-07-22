package com.edumind.domain;

import lombok.Data;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


@Data
public class StudentEvaluation {

    private Long id;// 评价ID（数据库主键）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public double getSentimentScore() {
        return sentimentScore;
    }

    public void setSentimentScore(double sentimentScore) {
        this.sentimentScore = sentimentScore;
    }

    public boolean isWarningTriggered() {
        return warningTriggered;
    }

    public void setWarningTriggered(boolean warningTriggered) {
        this.warningTriggered = warningTriggered;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Min(value = 1, message = "学生ID必须为正整数")
    @NotNull(message = "学生ID不能为空")
    private Long studentId;// 学生ID

    @NotNull(message = "评价内容不能为空")
    @Size(min = 20, max = 5000, message = "评价内容长度需在20～5000之间")
    private String content;             // 自我评价内容
    private String sentiment;           // 情绪标签（positive / negative / neutral）
    private double sentimentScore;      // 情感强度分数（例如 -1 ~ 1）

    private boolean warningTriggered;   // 是否触发心理健康预警
    private LocalDateTime createTime;   // 提交时间
}

