package com.chinasofti.service.performance.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.performance.PerrankMapper;
import com.chinasofti.model.performance.Perrank;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.performance.PerrankService;

@Service("perrankService")
public class PerrankServiceImpl implements PerrankService {
	@Autowired
	private PerrankMapper perrankMapper;

	@Override
	public DataGrid datagrid(Perrank perrank) {
		DataGrid dataGrid = new DataGrid();
		perrank.setPage((perrank.getPage() - 1) * perrank.getRows());
		dataGrid.setTotal(perrankMapper.count(perrank));
		dataGrid.setRows(perrankMapper.selectList(perrank));
		return dataGrid;
	}

	@Override
	public void add(Perrank perrank, HttpSession session) {
		perrank.setCreatedatetime(new Date());
		perrankMapper.insertSelective(perrank);
	}

	@Override
	public void edit(Perrank perrank, HttpSession session) {
		perrank.setModifydatetime(new Date());
		perrankMapper.updateByPrimaryKeySelective(perrank);
	}

	public void remove(Perrank perrank) {
		String[] ids = perrank.getIds().split(",");
		for (String id : ids) {
			perrankMapper.deleteByPrimaryKey(id);
		}
	}

}
