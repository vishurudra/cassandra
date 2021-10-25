package com.sample.training.util;

import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import java.util.List;

public class TableColumnUtil {

    public static void createTable(String tableName) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(tableName).append("(")
                .append("id uuid PRIMARY KEY, ")
                .append("title text,")
                .append("subject text);");

        String query = sb.toString();
        CassandraConnector cassandraConnector = new CassandraConnector();
        cassandraConnector.connect("127.0.0.1", 9042);
        Session session = cassandraConnector.getSession();
        session.execute(sb.toString());
        cassandraConnector.close();
    }

    public static void printColumns(String tableName) {
        CassandraConnector cassandraConnector = new CassandraConnector();
        cassandraConnector.connect("127.0.0.1", 9042);
        Session session = cassandraConnector.getSession();
        ResultSet result = session.execute(
                "SELECT * FROM " + tableName + ";");

        ColumnDefinitions columnNames =
                result.getColumnDefinitions();
        columnNames.asList().forEach(data -> {
            System.out.println(data.getName());
        });
    }
}
