package com.ccc.mybatis.executor;

import com.ccc.mybatis.mapping.BoundSql;
import com.ccc.mybatis.mapping.MappedStatement;
import com.ccc.mybatis.session.ResultHandler;
import com.ccc.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}