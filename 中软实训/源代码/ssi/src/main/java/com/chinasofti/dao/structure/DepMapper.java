package com.chinasofti.dao.structure;

import com.chinasofti.model.structure.Dep;

public interface DepMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Dep record);

    int insertSelective(Dep record);

    Dep selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);

    Dep selectRoot();
    Dep selectRootDefect();
}