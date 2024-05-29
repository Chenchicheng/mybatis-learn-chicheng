package com.ccc.mybatis.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.ccc.mybatis.io.Resources;
import com.ccc.mybatis.session.SqlSession;
import com.ccc.mybatis.session.SqlSessionFactory;
import com.ccc.mybatis.session.SqlSessionFactoryBuilder;
import com.ccc.mybatis.test.dao.IUserDao;
import com.ccc.mybatis.test.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
@Slf4j
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
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            log.info("测试结果：{}", JSONUtil.toJsonStr(user));
        }
    }
}
