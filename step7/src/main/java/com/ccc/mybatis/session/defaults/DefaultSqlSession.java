package com.ccc.mybatis.session.defaults;

import cn.hutool.json.JSONUtil;
import com.ccc.mybatis.binding.MapperRegistry;
import com.ccc.mybatis.executor.Executor;
import com.ccc.mybatis.mapping.BoundSql;
import com.ccc.mybatis.mapping.Environment;
import com.ccc.mybatis.mapping.MappedStatement;
import com.ccc.mybatis.session.Configuration;
import com.ccc.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;
    private final Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + "方法：" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        try {

            MappedStatement mappedStatement = configuration.getMappedStatement(statement);
            BoundSql boundSql = mappedStatement.getBoundSql();

            List<T> objList = executor.query(mappedStatement, parameter, Executor.NO_RESULT_HANDLER, boundSql);
            return objList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
