package com.chinasofti.dao.base;

import java.util.List;

import com.chinasofti.model.base.Afl;

public interface AflMapper {
    int deleteByPrimaryKey(String aflid);

    int insert(Afl record);

    int insertSelective(Afl record);

    Afl selectByPrimaryKey(String aflid);

    int updateByPrimaryKeySelective(Afl record);

    int updateByPrimaryKey(Afl record);

	Long count(Afl afl);

	List<Afl> selectList(Afl afl);
}