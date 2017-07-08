package com.chinasofti.dao.base;

import java.util.List;

import com.chinasofti.model.base.Bt;

public interface BtMapper {
    int deleteByPrimaryKey(String btid);

    int insert(Bt record);

    int insertSelective(Bt record);

    Bt selectByPrimaryKey(String btid);

    int updateByPrimaryKeySelective(Bt record);

    int updateByPrimaryKey(Bt record);

	Long count(Bt bt);

	List<Bt> selectList(Bt bt);
}