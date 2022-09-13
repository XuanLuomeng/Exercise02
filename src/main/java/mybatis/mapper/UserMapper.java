package mybatis.mapper;

public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名要一致
     * 2.映射文件中的sql语句的id要和mapper接口中的方法名一致
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     * @return
     */
    int updateUeser();

    /**
     * 删除用户信息
     */
    void deleteUser();
}
