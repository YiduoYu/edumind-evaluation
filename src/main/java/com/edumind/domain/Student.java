package com.edumind.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Setter
@Getter
public class Student {


    private Long id;

    @ExcelProperty(index = 0)
    @NotNull(message = "Student ID cannot be null")
    @Pattern(regexp = "^\\d{7}$", message = "Student ID must be a 7-digit number")
    private String studentId;

    @ExcelProperty(index = 1)
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @ExcelProperty(index = 2)
    @Min(value = 6, message = "age must not be less than 6")
    @Max(value = 30, message = "age must not be bigger than 30")
    private Integer age;

    @ExcelProperty(index = 3)
    @Email(message = "the email format is wrong")
    private String email;

    @ExcelProperty(index = 4)
    private String advisor;

    private LocalDateTime createTime;

}

