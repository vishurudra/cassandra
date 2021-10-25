package com.sample.training.util;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.util.List;

public class KeyspaceUtil {

    public static void createKeyspace(
            String keyspaceName, String replicationStrategy, int replicationFactor) {
        CassandraConnector cassandraConnector = new CassandraConnector();
        cassandraConnector.connect("127.0.0.1", 9042);
        Session session = cassandraConnector.getSession();
        StringBuilder sb =
                new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
                        .append(keyspaceName).append(" WITH replication = {")
                        .append("'class':'").append(replicationStrategy)
                        .append("','replication_factor':").append(replicationFactor)
                        .append("};");

        String query = sb.toString();
        session.execute(query);
        cassandraConnector.close();

    }

    public static void printAllKeyspaces() {
        CassandraConnector cassandraConnector = new CassandraConnector();
        cassandraConnector.connect("127.0.0.1", 9042);
        Session session = cassandraConnector.getSession();
        ResultSet result =
                session.execute("SELECT * FROM system_schema.keyspaces;");

        List<Row> matchedKeyspaces = result.all();
        for (Row row : matchedKeyspaces) {
            System.out.println(row.getString(0).toString());
        }


        cassandraConnector.close();

    }
}
