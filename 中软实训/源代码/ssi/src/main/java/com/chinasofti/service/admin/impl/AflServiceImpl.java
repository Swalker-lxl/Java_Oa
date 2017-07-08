package com.chinasofti.service.admin.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.base.AflMapper;
import com.chinasofti.model.base.Afl;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.admin.AflService;
import com.chinasofti.util.ToolUtil;
@Service("aflService")
public class AflServiceImpl implements AflService {
	@Autowired
	private AflMapper aflMapper;
	
	@Override
	public DataGrid datagrid(Afl afl) {
		DataGrid dataGrid = new DataGrid();
		afl.setPage((afl.getPage() - 1) * afl.getRows());
		dataGrid.setTotal(aflMapper.count(afl));
		dataGrid.setRows(aflMapper.selectList(afl));
		return dataGrid;
	}

	@Override
	public void add(Afl afl, HttpSession session) {
		
		afl.setAddtime(new Date());
		aflMapper.insertSelective(afl);
		
	}

	@Override
	public void edit(Afl afl, HttpSession session) {
		afl.setUpdatename(ToolUtil.user(session));
		afl.setUpdatetime(new Date());
		aflMapper.updateByPrimaryKeySelective(afl);
		
	}

	@Override
	public void remove(Afl afl) {
		String[] ids = afl.getIds().split(",");
		for (String id : ids) {
			aflMapper.deleteByPrimaryKey(id);	
	}
	}
}
