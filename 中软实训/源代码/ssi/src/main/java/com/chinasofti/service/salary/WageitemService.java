package com.chinasofti.service.salary;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.salary.wageitem;
import com.chinasofti.pageModel.DataGrid;

public interface WageitemService {
	public wageitem query(wageitem user);

	public void edit(wageitem user,HttpSession session);

	public DataGrid datagrid(wageitem user);

	public void add(wageitem user, HttpSession session);

	public void remove(wageitem user);
	

}
