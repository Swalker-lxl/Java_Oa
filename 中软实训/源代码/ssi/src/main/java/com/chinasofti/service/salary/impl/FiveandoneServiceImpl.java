package com.chinasofti.service.salary.impl;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.salary.FiveandoneMapper;
import com.chinasofti.model.salary.Fiveandone;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.salary.FiveandoneService;
@Service("fiveandoneService")
public class FiveandoneServiceImpl implements FiveandoneService{
	@Autowired
	private FiveandoneMapper fiveandoneMapper;
	@Override 
	public DataGrid datagrid(Fiveandone fiveandone) {
		DataGrid dataGrid = new DataGrid();
		fiveandone.setPage((fiveandone.getPage() - 1) * fiveandone.getRows());
		dataGrid.setTotal(fiveandoneMapper.count(fiveandone));
		dataGrid.setRows(fiveandoneMapper.selectList(fiveandone));
		return dataGrid;
	}
	@Override
	public void add(Fiveandone fiveandone, HttpSession session) {
		fiveandone.setId(fiveandone.getId());
		fiveandone.setFname(fiveandone.getFname());
		fiveandone.setScale(fiveandone.getScale());
		
		fiveandoneMapper.insertSelective(fiveandone);
		
	}
	@Override
	public void edit(Fiveandone fiveandone, HttpSession session) {
		fiveandone.setFname(fiveandone.getFname());
		fiveandone.setScale(fiveandone.getScale());
		
		fiveandoneMapper.updateByPrimaryKey(fiveandone);
	}
	@Override
	public void remove(Fiveandone fiveandone) {
			String[] ids = fiveandone.getIds().split(",");
			for (String id : ids) {
				fiveandoneMapper.deleteByPrimaryKey(id);
		}
	}


}
