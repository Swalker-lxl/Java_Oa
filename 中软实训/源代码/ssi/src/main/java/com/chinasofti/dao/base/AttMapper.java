package com.chinasofti.dao.base;

import java.util.List;

import com.chinasofti.model.base.Att;

public interface AttMapper {
    int deleteByPrimaryKey(String id);

    int insert(Att record);

    int insertSelective(Att record);

    Att selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Att record);

    int updateByPrimaryKey(Att record);

	Long count(Att att);

	List<Att> selectList(Att att);
}