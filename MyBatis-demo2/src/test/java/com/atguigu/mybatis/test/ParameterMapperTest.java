package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLoginByParam("admin","123456");
        System.out.println(user);

    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result= mapper.insertUser(new User(null,"李四","123",23,"男","123@qq.com"));
        System.out.println(result);

    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLogin("admin","123456");
        System.out.println(user);

    }
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user=mapper.checkLoginByMap(map);
        System.out.println(user);

    }

    @Test
    public void getGetUserByUsername(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);

    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user-> System.out.println(user));

    }






}
