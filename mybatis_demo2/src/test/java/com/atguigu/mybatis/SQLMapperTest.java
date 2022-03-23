package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-20 19:50
 */
public class SQLMapperTest {


    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "ton", "123", 23, "男", "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);
        //输出：user{id=10, username='ton', password='123', age=23, sex='男', email='123@321.com'}，自增主键存放到了user的id属性中
    }
    /**
     * 动态获取表名只能使用${}，因为表名不能加单引号
     */
    @Test
    public void testGetUserByTable(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTable("t_user");
        System.out.println(list);
    }

    /**
     * 删除只能使用\${}，如果使用#{}，
     */
    @Test
    public void testdeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }
}
