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
        ZooKeeper zooKeeper = new ZooKeeper("192.168.52.134",2000,null);
        //zooKeeper.create("/root","root data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.setData("/root","hello".getBytes(),-1);
        Stat stat = new Stat();
        byte [] datas = zooKeeper.getData("/root",false,stat);
        //zooKeeper.delete("/root",-1);
        System.out.println(new String(datas));
    }
}
