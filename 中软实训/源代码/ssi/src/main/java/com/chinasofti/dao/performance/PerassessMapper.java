package com.chinasofti.dao.performance;

import java.util.List;

import com.chinasofti.model.performance.Perassess;

public interface PerassessMapper {
    int deleteByPrimaryKey(String id);

    int insert(Perassess record);

    int insertSelective(Perassess record);

    Perassess selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Perassess record);

    int updateByPrimaryKey(Perassess record);

	Long count(Perassess perassess);

	List<Perassess> selectList(Perassess perassess);
}