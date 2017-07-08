package com.chinasofti.service.performance.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.performance.KpiMapper;
import com.chinasofti.model.admin.User;
import com.chinasofti.model.performance.Kpi;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.performance.KpiService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;

@Service("kpiService")
public class KpiServiceImpl implements KpiService{
	@Autowired
	private KpiMapper kpiMapper;
	
	@Override
	public DataGrid datagrid(Kpi kpi) {
		DataGrid dataGrid = new DataGrid();
		kpi.setPage((kpi.getPage() - 1) * kpi.getRows());
		dataGrid.setTotal(kpiMapper.count(kpi));
		dataGrid.setRows(kpiMapper.selectList(kpi));
		return dataGrid;
	}

	@Override
	public void add(Kpi kpi, HttpSession session) {
		kpi.setCreatetime(new Date());
		kpiMapper.insertSelective(kpi);
	}

	@Override
	public void edit(Kpi kpi, HttpSession session) {
    kpi.setModifytime(new Date());
    kpiMapper.updateByPrimaryKeySelective(kpi);
	}
	@Override
	public void remove(Kpi kpi) {
		String[] ids = kpi.getIds().split(",");
		for (String id : ids) {
			kpiMapper.deleteByPrimaryKey(id);
		}
	}

}
