package com.chinasofti.service.structure.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.structure.PosMapper;
import com.chinasofti.model.structure.Pos;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.structure.PosService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;
@Service("posService")
public class PosServiceImpl implements PosService {
	@Autowired
	private PosMapper posMapper;
	@Override
	public Pos query(Pos post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Pos post, HttpSession session) {
		post.setUpdatename(ToolUtil.user(session));
		post.setUpdatetime(new Date());
		posMapper.updateByPrimaryKeySelective(post);
	}

	@Override
	public DataGrid datagrid(Pos post) {
		DataGrid dataGrid = new DataGrid();
		post.setPage((post.getPage() - 1) * post.getRows());
		dataGrid.setTotal(posMapper.count(post));
		dataGrid.setRows(posMapper.selectList(post));
		return dataGrid;
	}

	@Override
	public void add(Pos post, HttpSession session) {
		
		post.setAddname(ToolUtil.user(session));
		post.setAddtime(new Date());
		posMapper.insertSelective(post);
		
	}

	@Override
	public void remove(Pos post) {
		String[] ids = post.getIds().split(",");
		for (String id : ids) {
			posMapper.deleteByPrimaryKey(id);
		}
	}


	
	
}
