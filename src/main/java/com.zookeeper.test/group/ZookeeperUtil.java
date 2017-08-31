package group;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * author 45208
 * date 2017/7/5
 **/
public class ZookeeperUtil {
    private ZooKeeper zooKeeper;

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public void connect() throws IOException {
        zooKeeper = new ZooKeeper("192.168.52.134",5000,null);
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
