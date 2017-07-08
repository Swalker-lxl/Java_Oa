package com.chinasofti.dao.salary;

import java.util.List;

import com.chinasofti.model.salary.Swage;

public interface SwageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Swage record);

    int insertSelective(Swage record);

    Swage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Swage record);

    int updateByPrimaryKey(Swage record);
    
	Long count(Swage user);

	List<Swage> selectList(Swage user);
}