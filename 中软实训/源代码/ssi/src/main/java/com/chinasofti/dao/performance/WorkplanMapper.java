package com.chinasofti.dao.performance;

import java.util.List;

import com.chinasofti.model.performance.Workplan;

public interface WorkplanMapper {
    int deleteByPrimaryKey(String id);

    int insert(Workplan record);

    int insertSelective(Workplan record);

    Workplan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Workplan record);

    int updateByPrimaryKey(Workplan record);

	Long count(Workplan workplan);

	List<Workplan> selectList(Workplan workplan);
}