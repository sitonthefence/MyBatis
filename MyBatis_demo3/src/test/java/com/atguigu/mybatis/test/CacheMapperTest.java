package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testCache(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEid(1);
        System.out.println(emp1);
        Emp emp2 = mapper.getEmpByEid(1);
        System.out.println(emp2);
    }
    @Test
    public void testTwoCache(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(resourceAsStream);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1 = mapper1.getEmpByEid(1);
            System.out.println(emp1);
            sqlSession1.commit();


            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2 = mapper2.getEmpByEid(1);
            System.out.println(emp2);
       //     sqlSession2.close();

            SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
            CacheMapper mapper3 = sqlSession3.getMapper(CacheMapper.class);
            Emp emp3 = mapper3.getEmpByEid(1);
            System.out.println(emp3);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
