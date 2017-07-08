package com.chinasofti.service.employee;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.employee.EmployeeFile;
import com.chinasofti.pageModel.DataGrid;

public interface EmployeeFileService {

	DataGrid datagrid(EmployeeFile emp);

	void add(EmployeeFile emp, HttpSession session);

	void edit(EmployeeFile emp, HttpSession session);

	void remove(EmployeeFile emp);

}
