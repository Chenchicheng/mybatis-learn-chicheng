package com.ccc.mybatis.test.dao;

import com.ccc.mybatis.binding.MapperProxyFactory;
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
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("com.ccc.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.ccc.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);

        String res = userDao.queryUserName("10001");
        System.out.println(("测试结果：" +  res));
    }
}
