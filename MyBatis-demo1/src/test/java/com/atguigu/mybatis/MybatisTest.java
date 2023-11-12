package com.atguigu.mybatis;

import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
   @Test

    public void testMyBatis() throws IOException {
       InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
       SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
       SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
       SqlSession sqlSession = sqlSessionFactory.openSession();
       UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       int result = mapper.insertUser();
       sqlSession.commit();
       sqlSession.close();
       System.out.println("result："+result);

      }
   @Test
      public void testCRUD() throws IOException {
      InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
      SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
      SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//      mapper.updateUser();
      //mapper.deleteUser();
      User user=mapper.getUserById();
      System.out.println(user);
      List<User> list = mapper.getAllUser();
      list.forEach(System.out::println);
   }

   @Test
   public void testSelect() throws IOException {
      InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
      SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
      SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.jiangYangGetUserById();
      System.out.println(user);

   }

}
