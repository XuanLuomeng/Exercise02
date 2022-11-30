package week1.day02;

import java.util.Random;

public class Verification {
    public static void main(String[] args) {
        Random rd = new Random();
        String vc = "1234567890abcdefghijklmnopqrstuvwxwzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String verification = "";
        for (int i = 0; i < 5; i++) {
            int num = rd.nextInt(58);
            verification += vc.charAt(num);
        }
        System.out.println("验证码为:"+verification);
    }
}
