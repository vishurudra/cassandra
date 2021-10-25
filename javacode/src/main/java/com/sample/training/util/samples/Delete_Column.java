package com.sample.training.util.samples;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Delete_Column {

    public static void main(String args[]) {

        //Query
        String query = "ALTER TABLE emp DROP emp_email;";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("tp");

        //executing the query
        session.execute(query);

        System.out.println("Column deleted");
    }
}