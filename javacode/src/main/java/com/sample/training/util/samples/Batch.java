package com.sample.training.util.samples;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Batch {

    public static void main(String args[]){

        //query
        String query =" BEGIN BATCH INSERT INTO emp (emp_id, emp_city, emp_name, emp_phone, emp_sal) values( 4,'Pune','rajeev',9848022331, 30000);"

                + "UPDATE emp SET emp_sal = 50000 WHERE emp_id =3;"
                + "DELETE emp_city FROM emp WHERE emp_id = 2;"
                + "APPLY BATCH;";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("jpmc");

        //Executing the query
        session.execute(query);

        System.out.println("Changes done");
    }
}