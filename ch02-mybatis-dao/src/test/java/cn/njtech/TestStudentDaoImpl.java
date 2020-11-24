package cn.njtech;

import cn.njtech.dao.StudentDao;
import cn.njtech.dao.daoImpl.StudentDaoImpl;
import cn.njtech.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestStudentDaoImpl {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println(student));
    }
    @Test
    public void testInsertStudent() {
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student(9, "ljl", 21);
        int nums = dao.insertStudent(student);
        System.out.println("添加对象的数量是" + nums);
    }
}
