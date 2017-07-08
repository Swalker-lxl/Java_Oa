package com.chinasofti.dao.structure;

import java.util.List;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.structure.Pos;

public interface PosMapper {
    int deleteByPrimaryKey(String id);

    int insert(Pos record);

    int insertSelective(Pos record);

    Pos selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Pos record);

    int updateByPrimaryKey(Pos record);
    Long count(Pos post);

	List<Pos> selectList(Pos postr);
}