package group;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * author 45208
 * date 2017/7/6
 **/
public class UpdateConfig {
    public static final String path = "/config";
    private ZookeeperStore store;
    private Random random = new Random();
    public void config() throws IOException {
        store = new ZookeeperStore();
        store.connect();
    }

    public void run() throws KeeperException, InterruptedException {
        while(true){
            String value = String.valueOf(random.nextInt());
            store.write(path,value);
            System.out.printf("UpdateConfig:Set %s to %s\n",path,value);
            Thread.sleep(2000);
        }
    }

    public static  void main(String [] args){
        UpdateConfig config = new UpdateConfig();
        try {
            config.config();
            config.run();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
