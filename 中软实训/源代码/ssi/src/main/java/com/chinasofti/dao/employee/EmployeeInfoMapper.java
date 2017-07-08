package com.chinasofti.dao.employee;

import java.util.List;

import com.chinasofti.model.employee.EmployeeInfo;

public interface EmployeeInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(EmployeeInfo record);

    int insertSelective(EmployeeInfo record);

    EmployeeInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EmployeeInfo record);

    int updateByPrimaryKey(EmployeeInfo record);

	Long count(EmployeeInfo emp);

	List<EmployeeInfo> selectList(EmployeeInfo emp);
}