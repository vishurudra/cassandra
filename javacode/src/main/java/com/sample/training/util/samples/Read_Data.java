package com.sample.training.util.samples;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Read_Data {

    public static void main(String args[]) throws Exception {

        //queries
        String query = "SELECT * FROM emp";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("jpmc");

        //Getting the ResultSet
        ResultSet result = session.execute(query);

        File f = new File("C://cassandra//emp.csv");
        List<String> stringList = new ArrayList<>();
        for (Row row : result.all()) {

            stringList.add(row.toString());
        }
        FileUtils.writeLines(f, stringList);
        session.close();
        cluster.close();
    }
}
