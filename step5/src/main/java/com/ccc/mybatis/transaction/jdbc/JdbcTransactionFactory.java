package com.ccc.mybatis.transaction.jdbc;

import com.ccc.mybatis.session.TransactionIsolationLevel;
import com.ccc.mybatis.transaction.Transaction;
import com.ccc.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author chenchicheng
 * @date 2024/5/7
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
