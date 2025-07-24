package com.edumind.mapper;

import com.edumind.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student selectStudentByStudentId(String studentId);
    List<Student> selectAllStudents();
    Student selectStudentByEmail(String email);
    void insertStudent(Student student);
}