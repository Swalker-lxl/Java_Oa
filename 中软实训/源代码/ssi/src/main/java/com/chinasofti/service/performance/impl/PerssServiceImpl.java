package com.chinasofti.service.performance.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.performance.PerrankMapper;
import com.chinasofti.dao.performance.PerssMapper;
import com.chinasofti.model.performance.Perrank;
import com.chinasofti.model.performance.Perss;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.performance.PerssService;

@Service("perssService")
public class PerssServiceImpl implements PerssService {

	@Autowired
	private PerssMapper perssMapper;

	@Override
	public DataGrid datagrid(Perss perss) {
		DataGrid dataGrid = new DataGrid();
		perss.setPage((perss.getPage() - 1) * perss.getRows());
		dataGrid.setTotal(perssMapper.count(perss));
		dataGrid.setRows(perssMapper.selectList(perss));
		return dataGrid;
	}

	@Override
	public void add(Perss perss, HttpSession session) {
		perss.setCreatedatetime(new Date());
		perssMapper.insertSelective(perss);
	}

	@Override
	public void edit(Perss perss, HttpSession session) {
		perss.setModifydatetime(new Date());
		perssMapper.updateByPrimaryKeySelective(perss);
	}

	public void remove(Perss perss) {
		String[] ids = perss.getIds().split(",");
		for (String id : ids) {
			perssMapper.deleteByPrimaryKey(id);
		}
	}
}
