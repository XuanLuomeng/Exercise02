package week9.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LuoXuanwei
 * @date 2023/10/11 19:58
 */
public class LoadBalancer {
    private static LoadBalancer instance = null;
    private List serverList = null;

    private LoadBalancer() {
        serverList = new ArrayList();
    }

    public static LoadBalancer getInstance() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    public void addServer(String server) {
        serverList.add(server);
    }

    public void removeServer(String server) {
        serverList.remove(server);
    }

    /**
     * 通过redis,nginx,eureka等框架的学习，
     * 轮询的方式分发服务器才是比较常见且比较适用的方式，
     * 在这使用比较简洁的随机方式进行服务器分发
     * @return
     */
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }
}
