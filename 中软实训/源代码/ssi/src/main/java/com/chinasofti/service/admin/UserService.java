package com.chinasofti.service.admin;

import javax.servlet.http.HttpSession;
import com.chinasofti.model.admin.User;
import com.chinasofti.pageModel.DataGrid;

public interface UserService {
	
	public User query(User user);

	public void edit(User user,HttpSession session);

	public DataGrid datagrid(User user);

	public void add(User user, HttpSession session);

	public void remove(User user);

}
