package com.ccc.mybatis.test.dao;

import com.ccc.mybatis.binding.MapperProxyFactory;
import com.ccc.mybatis.binding.MapperRegistry;
import com.ccc.mybatis.session.SqlSession;
import com.ccc.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public class ApiTest {

    @Test
    public void test_MapperProxyFactory() {

        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.ccc.mybatis.test.dao");

        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        Object o = userDao.queryUserName("ccc");
        System.out.println(o.toString());

    }
}
