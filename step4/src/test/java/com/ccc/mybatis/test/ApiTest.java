package com.ccc.mybatis.test;

import com.ccc.mybatis.io.Resources;
import com.ccc.mybatis.session.SqlSession;
import com.ccc.mybatis.session.SqlSessionFactory;
import com.ccc.mybatis.session.SqlSessionFactoryBuilder;
import com.ccc.mybatis.test.dao.IUserDao;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public class ApiTest {


    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        System.out.println(res);
    }
}
