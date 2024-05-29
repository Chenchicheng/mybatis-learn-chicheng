package com.ccc.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chenchicheng
 * @date 2024/5/7
 */
public interface Transaction {
    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
