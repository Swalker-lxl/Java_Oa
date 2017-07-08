package com.chinasofti.dao.salary;

import java.util.List;

import com.chinasofti.model.salary.wageitem;

public interface wageitemMapper {
    int deleteByPrimaryKey(String waid);

    int insert(wageitem record);

    int insertSelective(wageitem record);

    wageitem selectByPrimaryKey(String waid);

    int updateByPrimaryKeySelective(wageitem record);

    int updateByPrimaryKey(wageitem record);
    Long count(wageitem swage);

	List<wageitem> selectList(wageitem user);
}