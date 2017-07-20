package com.zookeeper.test.acl;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JINRUN.XIE
 * @since 2017/7/20
 */
public class ZookeeperAcl {
    public static void main(String [] args){
        ZookeeperAcl acl = new ZookeeperAcl();
        acl.create();
        acl.setById();
        acl.set();
        acl.read();
        acl.delete();
    }

    public void create() {
        List<ACL> aclList = new ArrayList<>();
        try {
            Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin"));
            ACL acl1 = new ACL(Perms.ALL,id1);
            aclList.add(acl1);
            Id id2 = new Id("world","anyone");
            ACL acl2 = new ACL(Perms.READ,id2);
            aclList.add(acl2);
            ZooKeeper zooKeeper = new ZooKeeper("192.168.47.128:2181",2000,null);
            zooKeeper.addAuthInfo("digest","admin:admin".getBytes());
            zooKeeper.create("/test1","hello".getBytes(),aclList, CreateMode.PERSISTENT);
            Stat stat = zooKeeper.exists("/test", null);
            if(stat != null){
                byte []  data = zooKeeper.getData("/test1",false, null);
                System.out.println("create:"+new String(data));
            }
            zooKeeper.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    private void setById(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.47.128:2181",2000,null);
            zooKeeper.addAuthInfo("digest","admin:admin".getBytes());
            Stat stat = zooKeeper.exists("/test1", null);
            if(stat != null){
               zooKeeper.setData("/test1","hello1".getBytes(),-1);
            }
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    private void set(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.47.128:2181",2000,null);
            Stat stat = zooKeeper.exists("/test1", null);
            if(stat != null){
                zooKeeper.setData("/test1","hello2".getBytes(),-1);
            }
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    public void readById(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.47.128:2181",2000,null);
            zooKeeper.addAuthInfo("world","anyone".getBytes());
            Stat stat = zooKeeper.exists("/test1", null);
            if(stat != null){
                byte []  data = zooKeeper.getData("/test1",false, null);
                System.out.println("readById"+new String(data));
            }
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    public void read(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.47.128:2181",2000,null);
            Stat stat = zooKeeper.exists("/test1", null);
            if(stat != null){
                byte []  data = zooKeeper.getData("/test1",false, null);
                System.out.println("read:"+new String(data));
            }
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.47.128:2181",2000,null);
            zooKeeper.addAuthInfo("digest","admin:admin".getBytes());
            Stat stat = zooKeeper.exists("/test1", null);
            if(stat != null){
                zooKeeper.delete("/test1",-1);
            }
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
