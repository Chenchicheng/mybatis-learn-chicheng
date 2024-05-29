package com.ccc.mybatis.session;

import com.ccc.mybatis.binding.MapperRegistry;
import com.ccc.mybatis.datasource.durid.DruidDataSourceFactory;
import com.ccc.mybatis.datasource.pooled.PooledDataSourceFactory;
import com.ccc.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import com.ccc.mybatis.executor.Executor;
import com.ccc.mybatis.executor.SimpleExecutor;
import com.ccc.mybatis.executor.results.DefaultResultSetHandler;
import com.ccc.mybatis.executor.results.ResultSetHandler;
import com.ccc.mybatis.executor.statement.PreparedStatementHandler;
import com.ccc.mybatis.executor.statement.StatementHandler;
import com.ccc.mybatis.mapping.BoundSql;
import com.ccc.mybatis.mapping.Environment;
import com.ccc.mybatis.mapping.MappedStatement;
import com.ccc.mybatis.transaction.Transaction;
import com.ccc.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.ccc.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchicheng
 * @date 2024/4/19
 */
public class Configuration {

    MapperRegistry mapperRegistry = new MapperRegistry();
    Map<String, MappedStatement> mappedStatements = new HashMap<>();
    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    //环境
    protected Environment environment;

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public StatementHandler newStatementHandler(SimpleExecutor simpleExecutor, MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(simpleExecutor, ms, parameter, resultHandler, boundSql);
    }

    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    public Executor newExecutor(Transaction tx) {
        return new SimpleExecutor(this, tx);
    }
}
