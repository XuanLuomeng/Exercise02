package week9.day6;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:36
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean findUserById(String userId) {
        if (userId.equals("zhangsan")) {
            System.out.println("用户id:" + userId + "\t登陆成功");
            return true;
        } else {
            System.out.println("用户id:" + userId + "\t登陆失败");
            return false;
        }
    }
}
