package com.chinasofti.service.performance;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.performance.Perss;
import com.chinasofti.pageModel.DataGrid;

public interface PerssService {

	DataGrid datagrid(Perss perss);

	void add(Perss perss, HttpSession session);

	void edit(Perss perss, HttpSession session);

	void remove(Perss perss);

}
