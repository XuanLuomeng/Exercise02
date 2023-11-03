package week9.day5;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:01
 */
public class AccessValidator {
    public boolean validate(String userId) {
        if (userId.equals("zhangsan")) {
            System.out.println(userId + "\t登陆成功!");
            return true;
        } else {
            System.out.println(userId + "\t登陆失败!");
            return false;
        }
    }
}
