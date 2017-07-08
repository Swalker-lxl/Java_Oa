package com.chinasofti.service.salary;

import javax.servlet.http.HttpSession;
import com.chinasofti.model.admin.User;
import com.chinasofti.model.salary.Swage;
import com.chinasofti.pageModel.DataGrid;

public interface SwageService {
	
	public Swage query(Swage user);

	public void edit(Swage user,HttpSession session);

	public DataGrid datagrid(Swage user);

	public void add(Swage user, HttpSession session);

	public void remove(Swage user);

}
