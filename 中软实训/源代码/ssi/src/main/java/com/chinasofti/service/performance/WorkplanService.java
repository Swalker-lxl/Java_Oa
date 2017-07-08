package com.chinasofti.service.performance;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.performance.Workplan;
import com.chinasofti.pageModel.DataGrid;

public interface WorkplanService {

	DataGrid datagrid(Workplan workplan);

	void add(Workplan workplan, HttpSession session);

	void edit(Workplan workplan, HttpSession session);

	void remove(Workplan workplan);

}
