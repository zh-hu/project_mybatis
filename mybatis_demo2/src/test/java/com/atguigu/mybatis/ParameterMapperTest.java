package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghu
 * @create 2022-03-20 15:52
 */
public class ParameterMapperTest {
    /**
     * 可以通过@Param注解标识mapper接口中的方法参数，此时，会将这些参数放在map集合中
     * 需要通过\${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
     */
    @Test
    public void checkLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.CheckLoginByParam("张三", "123456");
        System.out.println(user);
    }
    /**
     * 若mapper接口中的方法参数为实体类对象时此时可以使用${}和#{}
     * 通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
     */
    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null,"李四","123456",12,"男","123@321.com"));
        System.out.println(result);
    }
    /**
     * 若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，
     * 将这些数据放在map中只需要通过\${}和#{}访问map集合的键就可以获取相对应的值
     * 注意${}需要手动加单引号
     */
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","张三");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    /**
     * 若mapper接口中的方法参数为多个时，此时MyBatis会自动将这些参数放在一个map集合中
     * 1. 以arg0,arg1...为键，以参数为值；
     * 2. 以param1,param2...为键，以参数为值；
     *
     */
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张三","123456");
        System.out.println(user);
    }
    /**
     * MyBatis获取参数值的两种方式，${} 和#{}
     * ${}的本质就是字符串拼接
     * #{}的本质就是占位符赋值
     * mybatis获取参数值的各种情况：
     *      ${}使用字符串拼接的方式拼接sql，若为字符串类型或日期类型的字段进行赋值时，需要手动加单引号；
     *      #{}使用占位符赋值的方式拼接sql，此时为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号
     */
    @Test
    public void testGetUserByIdUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByIdUsername("张三");
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
    @Test
    public void testJDBC() throws Exception{
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("","","");
       //connection.prepareStatement("select * from t_user where username=");
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username=?");
        ps.setString(1,username);
    }
}
