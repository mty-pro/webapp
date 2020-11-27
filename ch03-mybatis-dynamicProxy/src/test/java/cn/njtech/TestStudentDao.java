package cn.njtech;

import cn.njtech.dao.StudentDao;
import cn.njtech.domain.Student;
import cn.njtech.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestStudentDao {
    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//        String sqlId = "cn.njtech.dao.StudentDao.selectStudents";
//        List<Student> list = sqlSession.selectList(sqlId);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectStudents();
        list.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao=" + dao.getClass().getName());
        Student student = new Student(19, "wwq", 19);
        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加对象的数量：" + num);
        sqlSession.close();
    }

    @Test
    public void testSelectStudentById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1);
        System.out.println("student=" + student);
        sqlSession.close();
    }
}
