package com.chinasofti.service.message;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.message.Mes;
import com.chinasofti.pageModel.DataGrid;

public interface MesService {
	public Mes query(Mes message);

	public void edit(Mes message,HttpSession session);

	public DataGrid datagrid(Mes message,HttpSession session);

	public void add(Mes message, HttpSession session);

	public void remove(Mes message);
}
