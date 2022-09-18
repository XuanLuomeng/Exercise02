package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * MyBatis获取参数值的两种方式：#{}和${}
 * #{}的本质是占位符赋值，${}的本质是字符串拼接
 * 1、若mapper接口方法的参数为单个字面量类型
 * 此时可以通过#{}和${}以任意的内容获取参数值，一定要注意${}的单引号问题(mybatis版本在3.4及以下两种方式区别很大)
 * 2、若mapper接口方法的参数为多个字面量类型
 * 此时MyBatis会将参数放在map集合中，以两种方式存储数据
 * a>以arg0,arg1……为键，以参数为值
 * b>以param1,param2……为键，以参数为值
 * 因此，只需要通过#{}和${}访问map集合的键，就可以获取相对应的值
 * 3、若mapper接口方法的参数为map集合类型的参数
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对应的值，一定要注意${}单引号问题
 * 4、若mapper接口方法的参数为实体类类型的参数
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值，一定要注意${}单引号问题
 * 5、可以在mapper接口方法的参数上设置@Param注解
 * 此时MyBatis会将这这些参数放在map中，以两种方式进行存储
 * a>以@Param注解的value属性值为键，以参数为值
 * b>以param1，param2……为键，以参数为值
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对应的值，一定要注意${}单引号问题
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     *
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录(以map集合作为参数)
     *
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
    /**
     * 以下为第一版本练习
     */
//    /**
//     * MyBatis面向接口编程的两个一致
//     * 1.映射文件的namespace要和mapper接口的全类名要一致
//     * 2.映射文件中的sql语句的id要和mapper接口中的方法名一致
//     */
//
//    /**
//     * 添加用户信息
//     */
//    int insertUser();
//
//    /**
//     * 修改用户信息
//     * @return
//     */
//    int updateUeser();
//
//    /**
//     * 删除用户信息
//     */
//    void deleteUser();
//
//    /**
//     * 根据用户id查询信息
//     */
//    User getUserById();
//
//    /**
//     * 查询所有的用户信息
//     * @return
//     */
//    List<User> getAllUser();
}
