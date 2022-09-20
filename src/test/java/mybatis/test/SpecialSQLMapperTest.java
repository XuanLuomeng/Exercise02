package mybatis.test;

import mybatis.mapper.SpecisalSQLMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecisalSQLMapper mapper = sqlSession.getMapper(SpecisalSQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }

    @Test
    public void testJDBC(){
        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("","","");
            String sql = "select * from t_user where '%?%'";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setString(1,"a");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
