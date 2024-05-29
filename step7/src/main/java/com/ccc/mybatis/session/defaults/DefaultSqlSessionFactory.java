package com.ccc.mybatis.session.defaults;

import com.ccc.mybatis.binding.MapperRegistry;
import com.ccc.mybatis.executor.Executor;
import com.ccc.mybatis.mapping.Environment;
import com.ccc.mybatis.session.Configuration;
import com.ccc.mybatis.session.SqlSession;
import com.ccc.mybatis.session.SqlSessionFactory;
import com.ccc.mybatis.session.TransactionIsolationLevel;
import com.ccc.mybatis.transaction.Transaction;
import com.ccc.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @author chenchicheng
 * @date 2024/4/16
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
