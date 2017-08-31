package group;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * author 45208
 * date 2017/7/10
 **/
public class ZookeeperGroup extends ZookeeperUtil{
    public void join(String groupName){
        String path = "/"+groupName;
        try {
            Stat stat = getZooKeeper().exists(path,false);
            if(stat == null){
                String result = getZooKeeper().create(path,groupName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println("create group:"+result);
            }else{
                System.out.println("group exists");
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void display(String groupName){
        String path = "/"+groupName;
        while(true){
            try {
                List<String> children = getZooKeeper().getChildren(path,false);
                System.out.println("当前存在的子节点:");
                if(children != null && children.size() > 0){
                    for(String child : children){
                        System.out.println(child);
                    }
                }
                Thread.sleep(2000);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
