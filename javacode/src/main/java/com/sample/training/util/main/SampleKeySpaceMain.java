package com.sample.training.util.main;

import com.sample.training.util.KeyspaceUtil;
import com.sample.training.util.TableColumnUtil;

public class SampleKeySpaceMain {
    public static void main(String[] args) {
       /* KeyspaceUtil.createKeyspace("jpmc",
                "SimpleStrategy",1);
        System.out.println("Done");
        KeyspaceUtil.printAllKeyspaces();*/
         TableColumnUtil.createTable("jpmc.book");
        TableColumnUtil.printColumns("jpmc.book");
    }
}
