package com.edumind.service.Impl;

import com.edumind.domain.Student;
import com.edumind.mapper.StudentMapper;
import com.edumind.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private Validator validator;

    @Override
    public Student getStudentById(String id) {
        return studentMapper.selectStudentByStudentId(id);
    }


    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public int batchInsertStudents(List<@Valid Student> students) {
        int successCount = 0;

        for (Student student : students) {
            Set<ConstraintViolation<Student>> violations = validator.validate(student);
            if (!violations.isEmpty()) {
                // 可以记录或打印这些错误
                for (ConstraintViolation<Student> violation : violations) {
                    System.out.println("Validation error: " + violation.getMessage());
                }
                continue; // 跳过不合法的学生
            }

            if (studentMapper.selectStudentByEmail(student.getEmail()) != null) {
                continue; // 邮箱重复
            }

            student.setCreateTime(LocalDateTime.now());
            studentMapper.insertStudent(student);
            successCount++;
        }

        return successCount;
    }
}

