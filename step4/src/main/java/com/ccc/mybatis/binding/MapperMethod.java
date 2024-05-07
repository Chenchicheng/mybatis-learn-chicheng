package com.ccc.mybatis.binding;

import com.ccc.mybatis.mapping.MappedStatement;
import com.ccc.mybatis.mapping.SqlCommandType;
import com.ccc.mybatis.session.Configuration;
import com.ccc.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * @author chenchicheng
 * @date 2024/5/7
 */
public class MapperMethod {

    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (command.getType()) {
            case DELETE:
            case INSERT:
            case UPDATE: break;
            case SELECT: result = sqlSession.selectOne(command.getName(), args); break;
            default: throw new RuntimeException("Unknown execution method for:" + command.getName());
        }
        return result;
    }

    public static class SqlCommand {
        private final String name;
        private final SqlCommandType type;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement mappedStatement = configuration.getMappedStatement(statementName);

            this.name = mappedStatement.getId();
            this.type = mappedStatement.getSqlCommandType();

        }

        public String getName() {
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }
}
