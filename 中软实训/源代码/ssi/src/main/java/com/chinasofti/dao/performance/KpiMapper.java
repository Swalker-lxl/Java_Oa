package com.chinasofti.dao.performance;

import java.util.List;

import com.chinasofti.model.performance.Kpi;

public interface KpiMapper {
    int deleteByPrimaryKey(String id);

    int insert(Kpi record);

    int insertSelective(Kpi record);

    Kpi selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Kpi record);

    int updateByPrimaryKey(Kpi record);

	Long count(Kpi kpi);

	List<Kpi> selectList(Kpi kpi);
}