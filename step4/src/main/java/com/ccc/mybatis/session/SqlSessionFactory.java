package com.ccc.mybatis.session;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
