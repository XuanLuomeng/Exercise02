package week9.day6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:44
 */
public class Client {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        InvocationHandler handler = new DaoLog(userDao);

        UserDao proxy = null;

        proxy = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, handler);
        proxy.findUserById("zhangsan");
        System.out.println("==================================");

        DataDao dataDao = new DataDaoImpl();
        handler = new DaoLog(dataDao);

        DataDao proxy_new = null;

        proxy_new = (DataDao) Proxy.newProxyInstance(DataDao.class.getClassLoader(), new Class[]{DataDao.class}, handler);
        proxy_new.selectDataById("008");
    }
}
