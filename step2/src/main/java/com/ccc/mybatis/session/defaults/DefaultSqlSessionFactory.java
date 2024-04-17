package com.ccc.mybatis.session.defaults;

import com.ccc.mybatis.binding.MapperRegistry;
import com.ccc.mybatis.session.SqlSession;
import com.ccc.mybatis.session.SqlSessionFactory;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
