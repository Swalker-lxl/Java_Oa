package com.chinasofti.service.performance.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.performance.KpiMapper;
import com.chinasofti.dao.performance.WorkplanMapper;
import com.chinasofti.model.performance.Kpi;
import com.chinasofti.model.performance.Workplan;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.performance.WorkplanService;

@Service("workplanService")
public class WorkplanServiceImpl implements WorkplanService {
	@Autowired
	private WorkplanMapper workplanMapper;

	@Override
	public DataGrid datagrid(Workplan workplan) {
		DataGrid dataGrid = new DataGrid();
		workplan.setPage((workplan.getPage() - 1) * workplan.getRows());
		dataGrid.setTotal(workplanMapper.count(workplan));
		dataGrid.setRows(workplanMapper.selectList(workplan));
		return dataGrid;
	}

	@Override
	public void add(Workplan workplan, HttpSession session) {
		workplan.setCreatedatetime(new Date());
		workplanMapper.insertSelective(workplan);
	}

	@Override
	public void edit(Workplan workplan, HttpSession session) {
		workplan.setModifydatetime(new Date());
		workplanMapper.updateByPrimaryKeySelective(workplan);
	}

	public void remove(Workplan workplan) {
		String[] ids = workplan.getIds().split(",");
		for (String id : ids) {
			workplanMapper.deleteByPrimaryKey(id);
		}
	}
}
