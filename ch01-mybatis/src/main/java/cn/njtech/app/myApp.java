package cn.njtech.app;




import cn.njtech.domain.Student;
import cn.njtech.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class myApp {
    public static void main(String[] args) throws IOException {
//        //定义主配置文件的位置
//        String config = "mybatis.xml";
//        //读取config表示的文件
//        InputStream in = Resources.getResourceAsStream(config);
//        //创建SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //创建SqlSessionFactory对象
//        SqlSessionFactory factory = builder.build(in);
//        //【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
//        SqlSession session = factory.openSession();

        SqlSession session = MyBatisUtils.getSqlSession();
        //指定要执行的sql语句的标识
        //【重要】sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "cn.njtech.dao.StudentDao.selectStudents";
        List<Student> res = session.selectList(sqlId);
        //输出结果

        res.forEach( stu -> System.out.println(stu));
        //关闭sqlSession对象
        session.close();

    }
}
