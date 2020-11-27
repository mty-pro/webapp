package cn.njtech.dao;

import cn.njtech.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
    Student selectStudentById(Integer id);
}
