package com.chinasofti.dao.admin;

import com.chinasofti.model.admin.Menu;

public interface MenuMapper {

	int deleteByPrimaryKey(String cid);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(String cid);

	Menu selectRoot();

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);

	Menu selectRootDefect();

}