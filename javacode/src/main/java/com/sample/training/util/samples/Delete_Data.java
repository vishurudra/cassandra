package com.sample.training.util.samples;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Delete_Data {

    public static void main(String args[]){

        //query
        String query = "DELETE FROM emp WHERE emp_id=3;";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("tp");

        //Executing the query
        session.execute(query);

        System.out.println("Data deleted");
    }
}
