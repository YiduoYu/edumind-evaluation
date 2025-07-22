package com.edumind.mapper;

import com.edumind.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student selectStudentById(Long id);
    List<Student> selectAllStudents();

    Student selectStudentByEmail(String email);
    int insertStudent(Student student);
}