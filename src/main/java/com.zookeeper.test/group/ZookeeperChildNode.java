package group;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

import java.io.IOException;

/**
 * author 45208
 * date 2017/7/10
 **/
public class ZookeeperChildNode extends ZookeeperUtil implements Runnable{

    private String childNode;

    private Long timeOut;

    public void run() {
        try {
            this.connect();
            this.getZooKeeper().create(childNode,childNode.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            Thread.sleep(timeOut);
            System.out.println(Thread.currentThread().getName()+"执行结束");
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    public String getChildNode() {
        return childNode;
    }

    public void setChildNode(String childNode) {
        this.childNode = childNode;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }
}
