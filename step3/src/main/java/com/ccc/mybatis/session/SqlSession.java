package com.ccc.mybatis.session;

/**
 * 定义执行 SQL 标准、获取映射器以及将来管理事务等
 *
 * @author chenchicheng
 * @date 2024/4/16
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
}
