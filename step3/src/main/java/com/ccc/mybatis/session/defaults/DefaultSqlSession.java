package com.ccc.mybatis.session.defaults;

import cn.hutool.json.JSONUtil;
import com.ccc.mybatis.binding.MapperRegistry;
import com.ccc.mybatis.mapping.MappedStatement;
import com.ccc.mybatis.session.Configuration;
import com.ccc.mybatis.session.SqlSession;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + "方法：" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + " \n入参：" + JSONUtil.toJsonStr(parameter) + "\n待执行SQL：" + mappedStatement.getSql());
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
