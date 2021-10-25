package com.sample.training.util.samples;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Create_Table {

    public static void main(String args[]){

        //Query
        String query = "CREATE TABLE emp(emp_id int PRIMARY KEY, "
                + "emp_name text, "
                + "emp_city text, "
                + "emp_sal varint, "
                + "emp_phone varint );";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("jpmc");

        //Executing the query
        session.execute(query);

        System.out.println("Table created");
        System.out.println("If session  is not closed, program will not terminate");
    }

}