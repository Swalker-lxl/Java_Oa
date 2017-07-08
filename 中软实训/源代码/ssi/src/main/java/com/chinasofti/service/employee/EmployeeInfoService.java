package com.chinasofti.service.employee;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.employee.EmployeeInfo;
import com.chinasofti.pageModel.DataGrid;

public interface EmployeeInfoService {

	DataGrid datagrid(EmployeeInfo emp);

	void add(EmployeeInfo emp, HttpSession session);

	void edit(EmployeeInfo emp, HttpSession session);

	void remove(EmployeeInfo emp);

}
