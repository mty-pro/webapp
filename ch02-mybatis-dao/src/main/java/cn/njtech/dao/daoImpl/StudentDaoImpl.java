package cn.njtech.dao.daoImpl;

import cn.njtech.dao.StudentDao;
import cn.njtech.domain.Student;
import cn.njtech.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "cn.njtech.dao.StudentDao.insertStudent";
//        Student stu = new Student(9, "ljl", 21);
        int num = sqlSession.insert(sqlId, student);
        //这种获取SqlSession的方式需要提交事务
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "cn.njtech.dao.StudentDao.selectStudents";
        List<Student> list = sqlSession.selectList(sqlId);
        sqlSession.close();
        return list;
    }
}
