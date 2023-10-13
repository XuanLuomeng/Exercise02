package week9.day4;

/**
 * @author LuoXuanwei
 * @date 2023/10/11 20:17
 */
public class Consumer {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = LoadBalancer.getInstance();

        loadBalancer.addServer("*** Server 01 ***");
        loadBalancer.addServer("*** Server 02 ***");
        loadBalancer.addServer("*** Server 03 ***");
        loadBalancer.addServer("*** Server 04 ***");
        loadBalancer.addServer("*** Server 05 ***");

        for (int i = 0; i < 200; i++) {
            System.out.println("分发请求的服务器为:" + loadBalancer.getServer());
        }
    }
}
