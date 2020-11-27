package cn.njtech.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    static {
        String config = "mybatis.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSqlSession() {
        //重量级对象       整个项目中有一个即可     从连接池中获取connection连接
        SqlSession sqlSession = null;
        if(factory != null) {
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }
}
