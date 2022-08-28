package day01;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * 通过shiro加盐加次数加密
 */
public class Md5ShiroTest {
    public static void main(String[] args) {
        //密码
        String password = "123456";
        //盐，每次执行盐都是不一致的，若要保存到数据库的数据，建议也要保存盐，
        String salt = UUID.randomUUID().toString();
        //加密
        SimpleHash simpleHash = new SimpleHash("MD5",password,salt,5);
        System.out.println(simpleHash);
    }
}
