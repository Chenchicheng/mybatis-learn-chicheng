package com.ccc.mybatis.executor.results;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

}