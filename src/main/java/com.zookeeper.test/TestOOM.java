package com.zookeeper.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JINRUN.XIE
 * @since 2017/8/24
 */
public class TestOOM {
    static class Obj{
        private byte [] bytes = "hello world".getBytes();
    }
    public static void main(String [] args){
        List<Obj> list = new ArrayList<>();
        while(true){
            list.add(new Obj());
        }
    }

}
