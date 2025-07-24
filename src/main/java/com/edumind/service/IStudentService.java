package com.edumind.service;


import com.edumind.domain.Student;

import java.util.List;

public interface IStudentService {

    Student getStudentById(String id);

    List<Student> getAllStudents();

    int batchInsertStudents(List<Student> students);
}