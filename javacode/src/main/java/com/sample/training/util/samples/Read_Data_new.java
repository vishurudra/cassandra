package com.sample.training.util.samples;

import com.datastax.driver.core.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Read_Data_new {

    public static void main(String args[]) throws Exception {

        //queries
        String query = "SELECT * FROM emp";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("jpmc");

        //Getting the ResultSet
        ResultSet result = session.execute(query);

        ColumnDefinitions columnDefinitions = result.getColumnDefinitions();

        for(ColumnDefinitions.Definition definition :columnDefinitions.asList()){
            System.out.println(definition.getName()+":"+definition.getTable()+":"+definition.getKeyspace()
            +":"+            definition.getType().getName().toString()
            );
        }


        
        session.close();
        cluster.close();
    }
}
