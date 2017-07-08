package com.chinasofti.dao.employee;

import java.util.List;

import com.chinasofti.model.employee.EmployeeFile;

public interface EmployeeFileMapper {
    int deleteByPrimaryKey(String tid);

    int insert(EmployeeFile record);

    int insertSelective(EmployeeFile record);

    EmployeeFile selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(EmployeeFile record);

    int updateByPrimaryKey(EmployeeFile record);

	Long count(EmployeeFile emp);

	List<EmployeeFile> selectList(EmployeeFile emp);
}