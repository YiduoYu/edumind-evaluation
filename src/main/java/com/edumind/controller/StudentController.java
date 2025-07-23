package com.edumind.controller;

import com.alibaba.excel.EasyExcel;
import com.edumind.common.AjaxResult;
import com.edumind.domain.Student;
import com.edumind.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//教师端查看学生
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/import")
    public AjaxResult importStudents(@RequestParam("file") MultipartFile file) {
        try {
            List<Student> students = EasyExcel.read(file.getInputStream())
                    .head(Student.class)
                    .sheet()
                    .doReadSync();

            int count = studentService.batchInsertStudents(students);
            return AjaxResult.success("Successfully imported " + count + " Student data(s)");
        } catch (Exception e) {
            return AjaxResult.error("导入失败：" + e.getMessage());
        }
    }
}


