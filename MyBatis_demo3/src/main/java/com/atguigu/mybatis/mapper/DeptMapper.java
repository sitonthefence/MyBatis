package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

  Dept getEmpAndDeptByStepTwo(@Param("did")Integer did);

  Dept getDeptAndEmp(@Param("did") Integer did);

  Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

}
