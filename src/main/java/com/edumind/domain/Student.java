package com.edumind.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Student {

    private Long id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("辅导员")
    private String advisor;

    private LocalDateTime createTime;

}

