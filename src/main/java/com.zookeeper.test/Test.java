package com.zookeeper.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * @author JINRUN.XIE
 * @since 2017/7/20
 */
public class Test {
    private static final String localFilePath1 = "D:\\devSources\\open-enterprise\\open-enterprise.iml";
    private static final String hdfsFilePath1 = "hdfs://172.16.91.213:9000/hadoop/tmp/open-enterprise.iml";
    private static final String localFilePath2 = "/home/hadoop/tmp/bb.txt";
    private static final String hdfsFilePath ="hdfs://172.16.91.213:9000/home/hadoop/tmp/aa.txt";
    private static final String hdfsDirctoryPath="hdfs://localhost:9000/home/hadoop/tmp";
    public static void main(String [] args){
        Test t = new Test();
        try {
            t.wirteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wirteFile() throws IOException {
        Configuration conf = new Configuration();
        Path path = new Path(hdfsFilePath1);
        FileSystem fs = path.getFileSystem(conf);
        fs.copyFromLocalFile(false,new Path(localFilePath1),path);
    }
}


