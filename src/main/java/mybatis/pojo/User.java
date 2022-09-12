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
}
