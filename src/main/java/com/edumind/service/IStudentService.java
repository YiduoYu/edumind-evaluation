package com.edumind.service;


import com.edumind.domain.Student;

import java.util.List;

public interface IStudentService {
    Student getStudentById(Long id);
    List<Student> getAllStudents();
}