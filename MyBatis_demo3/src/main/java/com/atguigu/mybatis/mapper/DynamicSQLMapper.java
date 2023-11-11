package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

  List<Emp> getEmpByCondition(Emp emp);

 int deleteMoreByArray(@Param("eids") Integer[] edis);

 int insertMoreByList(@Param("emps") List<Emp> emps);

}
