package com.chinasofti.dao.performance;

import java.util.List;

import com.chinasofti.model.performance.Perrank;

public interface PerrankMapper {
    int deleteByPrimaryKey(String id);

    int insert(Perrank record);

    int insertSelective(Perrank record);

    Perrank selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Perrank record);

    int updateByPrimaryKey(Perrank record);

	Long count(Perrank perrank);

	List<Perrank> selectList(Perrank perrank);
}