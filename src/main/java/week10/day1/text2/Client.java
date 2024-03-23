package week10.day1.text2;

/**
 * @author LuoXuanwei
 * @date 2023/11/22 23:25
 */
public class Client {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        account.handle("张三","zhangsan");
    }
}
