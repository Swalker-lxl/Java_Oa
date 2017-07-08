package com.chinasofti.service.structure;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.structure.Pos;
import com.chinasofti.pageModel.DataGrid;


public interface PosService {
	public Pos query(Pos post);

	public void edit(Pos post,HttpSession session);

	public DataGrid datagrid(Pos post);

	public void add(Pos post, HttpSession session);

	public void remove(Pos post);
}
