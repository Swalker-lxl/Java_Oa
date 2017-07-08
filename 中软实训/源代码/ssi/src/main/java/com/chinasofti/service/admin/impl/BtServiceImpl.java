package com.chinasofti.service.admin.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.base.BtMapper;
import com.chinasofti.model.base.Bt;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.admin.BtService;
import com.chinasofti.util.ToolUtil;
@Service("btService")
public class BtServiceImpl implements BtService {
	@Autowired
	private BtMapper btMapper;
	@Override
	public DataGrid datagrid(Bt bt) {
		DataGrid dataGrid = new DataGrid();
		bt.setPage((bt.getPage() - 1) * bt.getRows());
		dataGrid.setTotal(btMapper.count(bt));
		dataGrid.setRows(btMapper.selectList(bt));
		return dataGrid;
	}
	@Override
	public void add(Bt bt, HttpSession session) {
		bt.setAddname(ToolUtil.user(session));
		bt.setAddtime(new Date());
		btMapper.insertSelective(bt);
		
	}
	@Override
	public void edit(Bt bt, HttpSession session) {
		bt.setUpdatename(ToolUtil.user(session));
		bt.setUpdatetime(new Date());
		btMapper.updateByPrimaryKeySelective(bt);
		
	}
	@Override
	public void remove(Bt bt) {
		String[] ids = bt.getIds().split(",");
		for (String id : ids) {
			btMapper.deleteByPrimaryKey(id);
		}
		
	}

}
