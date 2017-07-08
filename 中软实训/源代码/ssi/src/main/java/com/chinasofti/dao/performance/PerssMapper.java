package com.chinasofti.dao.performance;

import java.util.List;

import com.chinasofti.model.performance.Perss;

public interface PerssMapper {
    int deleteByPrimaryKey(String id);

    int insert(Perss record);

    int insertSelective(Perss record);

    Perss selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Perss record);

    int updateByPrimaryKey(Perss record);

	Long count(Perss perss);

	List<Perss> selectList(Perss perss);
}