import group.ZookeeperGroup;

import java.io.IOException;

/**
 * author 45208
 * date 2017/7/11
 **/
public class ZookeeperTest1 {
    public static void main(String [] args){
        ZookeeperGroup group = new ZookeeperGroup();
        try {
            group.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        group.join("zoo");
        group.display("zoo");
    }
}
