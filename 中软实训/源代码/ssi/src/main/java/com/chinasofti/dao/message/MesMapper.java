package com.chinasofti.dao.message;

import java.util.List;

import com.chinasofti.model.message.Mes;

public interface MesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Mes record);

    int insertSelective(Mes record);

    Mes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Mes record);

    int updateByPrimaryKey(Mes record);
    
    Long count(Mes message);

	List<Mes> selectList(Mes message);
}