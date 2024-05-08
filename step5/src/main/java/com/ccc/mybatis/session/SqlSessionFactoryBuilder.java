package com.ccc.mybatis.session;

import com.ccc.mybatis.builder.xml.XMLConfigBuilder;
import com.ccc.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author chenchicheng
 * @date 2024/4/19
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}
