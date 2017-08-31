package group;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * author 45208
 * date 2017/7/5
 **/
public class ZookeeperWatch implements Watcher{
    private ZookeeperStore store;
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getType() == Event.EventType.NodeDataChanged){
            try {
                display();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void display() throws KeeperException, InterruptedException {
        String value = store.read(UpdateConfig.path,this);
        System.out.printf("ZookeeperWatch:Read %s as %s\n",UpdateConfig.path,value);
    }

    public void watch() throws IOException {
        store = new ZookeeperStore();
        store.connect();
    }

    public static void main(String [] args){
        ZookeeperWatch watch = new ZookeeperWatch();
        try {
            watch.watch();
            watch.display();
            Thread.sleep(Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
