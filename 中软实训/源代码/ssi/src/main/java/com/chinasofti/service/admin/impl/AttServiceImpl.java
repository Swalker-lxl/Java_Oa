package com.chinasofti.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.base.AttMapper;
import com.chinasofti.model.base.Att;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.admin.AttService;

@Service("attService")
public class AttServiceImpl implements AttService {
	@Autowired
	private AttMapper attMapper;
	@Override
	public DataGrid datagrid(Att att) {
		DataGrid dataGrid = new DataGrid();
		att.setPage((att.getPage() - 1) * att.getRows());
		dataGrid.setTotal(attMapper.count(att));
		dataGrid.setRows(attMapper.selectList(att));
		return dataGrid;

	}

}
