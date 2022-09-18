package mybatis.pojo;

import lombok.Data;

/**
 * Date:2021/11/26
 * author:XuanWei
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;

    public User(Integer id, String username, String password, Integer age, String sex, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }
}
