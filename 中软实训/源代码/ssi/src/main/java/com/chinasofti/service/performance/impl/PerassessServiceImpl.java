package com.chinasofti.service.performance.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.performance.KpiMapper;
import com.chinasofti.dao.performance.PerassessMapper;
import com.chinasofti.model.performance.Kpi;
import com.chinasofti.model.performance.Perassess;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.performance.PerassessService;

@Service("perassessService")
public class PerassessServiceImpl implements PerassessService {

	@Autowired
	private PerassessMapper perassessMapper;

	@Override
	public DataGrid datagrid(Perassess perassess) {
		DataGrid dataGrid = new DataGrid();
		perassess.setPage((perassess.getPage() - 1) * perassess.getRows());
		dataGrid.setTotal(perassessMapper.count(perassess));
		dataGrid.setRows(perassessMapper.selectList(perassess));
		return dataGrid;
	}

	@Override
	public void add(Perassess perassess, HttpSession session) {
		perassess.setCreatedatetime(new Date());
		perassessMapper.insertSelective(perassess);
	}

	@Override
	public void edit(Perassess perassess, HttpSession session) {
		perassessMapper.updateByPrimaryKeySelective(perassess);
	}

	public void remove(Perassess perassess) {
		String[] ids = perassess.getIds().split(",");
		for (String id : ids) {
			perassessMapper.deleteByPrimaryKey(id);
		}
	}
}
