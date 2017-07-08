package com.chinasofti.service.employee;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.employee.Job;
import com.chinasofti.pageModel.DataGrid;

public interface JobService {

	DataGrid datagrid(Job job);

	void add(Job job, HttpSession session);

	void edit(Job job, HttpSession session);

	void remove(Job job);

}
