package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void testCheckLoging() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin", "123456 ");
        System.out.println(user);
    }

    @Test
    public void testCheckLogingByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "root", "123456", 33, "女", "123@qq.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLogingByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("root", "123456");
        System.out.println(user);
    }
    /**
     * 以下第一版本练习
     */
//    @Test
//    public void testMyBatis() throws IOException {
//        //加载核心配置文件
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取SqlSessionFactoryBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //获取sqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        //获取sql的会话对象SqlSession，是MyBatis提供的操作数据库的对象
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //获取UserMapper的代理实现类对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //调用mapper接口中的方法，实现添加用户信息的功能
//        int result = mapper.insertUser();
//        System.out.println("result:" + result);
////        //提交事务
////        sqlSession.commit();
//        //关闭SqlSession
//        sqlSession.close();
//    }
//
//    @Test
//    public void testUpdate() {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUeser();
//        sqlSession.close();
//    }
//
//    @Test
//    public void testDelete() {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.deleteUser();
//        sqlSession.close();
//    }
//
//    @Test
//    public void testGetUserById() {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserById();
//        System.out.println(user);
//    }
//
//    @Test
//    public void testGetAllUser() {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> list = mapper.getAllUser();
//        list.forEach(System.out::println);
//    }
}
