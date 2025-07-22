package com.edumind.service.Impl;

import com.edumind.domain.Student;
import com.edumind.mapper.StudentMapper;
import com.edumind.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public int batchInsertStudents(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            student.setCreateTime(LocalDateTime.now());

            // 重复校验（可按手机号、邮箱、名字）
            if (studentMapper.selectStudentByEmail(student.getEmail()) == null) {
                studentMapper.insertStudent(student);
                count++;
            }
        }
        return count;
    }
}

