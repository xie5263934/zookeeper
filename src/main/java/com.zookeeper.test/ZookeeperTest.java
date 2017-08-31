import group.ZookeeperChildNode;
import group.ZookeeperGroup;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * author 45208
 * date 2017/6/6
 **/
public class ZookeeperTest {
    public static void main(String [] args) throws IOException, KeeperException, InterruptedException {
       /* ZooKeeper zooKeeper = new ZooKeeper("192.168.52.134",2000,null);
        //zooKeeper.create("/root","root data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.setData("/root","hello".getBytes(),-1);
        Stat stat = new Stat();
        byte [] datas = zooKeeper.getData("/root",false,stat);
        //zooKeeper.delete("/root",-1);
        System.out.println(new String(datas));*/
        ZookeeperChildNode node = new ZookeeperChildNode();
        node.setChildNode("/zoo/child1");
        node.setTimeOut(10000L);
        new Thread(node).start();
        ZookeeperChildNode node1 = new ZookeeperChildNode();
        node1.setChildNode("/zoo/child2");
        node1.setTimeOut(20000L);
        new Thread(node1).start();
        ZookeeperChildNode node2 = new ZookeeperChildNode();
        node2.setChildNode("/zoo/child3");
        node2.setTimeOut(30000L);
        new Thread(node2).start();
    }
}
