package com.ccc.mybatis.mapping;

import com.ccc.mybatis.session.Configuration;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author chenchicheng
 * @date 2024/4/19
 */
@Getter
@Setter
public class MappedStatement {

    private String id;

    private Configuration configuration;
    private SqlCommandType sqlCommandType;

    private BoundSql boundSql;
    MappedStatement() {
        // constructor disabled
    }


    /**
     * 建造者
     */
    public static class Builder {

        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, BoundSql boundSql) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.boundSql = boundSql;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }

    }
}
