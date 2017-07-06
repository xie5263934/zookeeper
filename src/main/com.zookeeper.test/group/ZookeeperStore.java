package group;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;

/**
 * author 45208
 * date 2017/7/6
 **/
public class ZookeeperStore extends ZookeeperUtil{
    private static final Charset CHARSET=Charset.forName("UTF-8");
    public void write(String path,String value) throws KeeperException, InterruptedException {
        Stat stat = this.getZooKeeper().exists(path,false);
        if(stat == null){
            this.getZooKeeper().create(path,value.getBytes(CHARSET), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }else{
            this.getZooKeeper().setData(path,value.getBytes(CHARSET),-1);
        }
    }

    public String read(String path, Watcher watcher) throws KeeperException, InterruptedException {
        byte[] data = this.getZooKeeper().getData(path,watcher,null);
        return new String(data,CHARSET);
    }
}
