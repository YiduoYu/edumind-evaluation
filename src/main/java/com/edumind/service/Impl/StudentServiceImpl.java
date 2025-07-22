package com.edumind.service.Impl;

import com.edumind.domain.Student;
import com.edumind.mapper.StudentMapper;
import com.edumind.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}