package com.chinasofti.service.salary.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chinasofti.dao.salary.wageitemMapper;
import com.chinasofti.model.salary.wageitem;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.salary.WageitemService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;
@Service("wageitemService")
public class WageitemServiceImpl implements WageitemService{
	@Autowired
	private wageitemMapper wageitemMapper;

	@Override
	public wageitem query(wageitem user) {
		return wageitemMapper.selectByPrimaryKey(user.getWaid());
	}

	@Override
	public void edit(wageitem user, HttpSession session) {
		user.setModifyname(ToolUtil.user(session));
		user.setModifytime(new Date());
		wageitemMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public DataGrid datagrid(wageitem user) {
		DataGrid dataGrid = new DataGrid();
		user.setPage((user.getPage() - 1) * user.getRows());
		dataGrid.setTotal(wageitemMapper.count(user));
		dataGrid.setRows(wageitemMapper.selectList(user));
		return dataGrid;
	}

	@Override
	public void add(wageitem user, HttpSession session) {
		user.setCreatename(ToolUtil.user(session));
		user.setCreatetime(new Date());
		wageitemMapper.insertSelective(user);
	}

	@Override
	public void remove(wageitem user) {
		String[] ids = user.getIds().split(",");
		for (String id : ids) {
			wageitemMapper.deleteByPrimaryKey(id);
		}
		
	}
	
	
	

}

