package com.chinasofti.service.message.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.message.MesMapper;
import com.chinasofti.model.message.Mes;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.message.MesService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;
@Service("mesService")
public class MesServiceImpl implements MesService {
	@Autowired
	private MesMapper mesMapper;

	@Override
	public Mes query(Mes message) {
		return mesMapper.selectByPrimaryKey(message.getId());
	}

	@Override
	public void edit(Mes message, HttpSession session) {
		String[] ids = message.getIds().split(",");
		for (String id : ids) {
		message.setId(id);
		message.setFlac("1");
		mesMapper.updateByPrimaryKeySelective(message);
		}
	
	}

	@Override
	public DataGrid datagrid(Mes message,HttpSession session) {
		DataGrid dataGrid = new DataGrid();
		String name[]=ToolUtil.user(session).split("/");
		message.setAcceptid(name[1]);
		message.setPage((message.getPage() - 1) * message.getRows());
		dataGrid.setTotal(mesMapper.count(message));
		dataGrid.setRows(mesMapper.selectList(message));
		
		return dataGrid;
	}

	@Override
	public void add(Mes message, HttpSession session) {
		message.setId((UUID.randomUUID().toString()));
		String name[]=ToolUtil.user(session).split("/");
		message.setSendid(name[1]);
		message.setFlac("0");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.format(new Date());
		
	
		 
	
		message.setSentime(df.format(new Date()));
		mesMapper.insertSelective(message);
	}

	@Override
	public void remove(Mes message) {
		String[] ids = message.getIds().split(",");
		for (String id : ids) {
			mesMapper.deleteByPrimaryKey(id);
		}
		
	}

}
