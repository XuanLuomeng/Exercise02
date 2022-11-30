package week1.day01;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 正常加密
 */
public class Md5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "123456";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        String hashpsw = new BigInteger(1,md.digest()).toString(16);
        System.out.println(hashpsw);
    }
}
