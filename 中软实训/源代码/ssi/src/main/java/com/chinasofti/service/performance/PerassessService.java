package com.chinasofti.service.performance;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.performance.Perassess;
import com.chinasofti.pageModel.DataGrid;

public interface PerassessService {

	DataGrid datagrid(Perassess perassess);

	void add(Perassess perassess, HttpSession session);

	void edit(Perassess perassess, HttpSession session);

	void remove(Perassess perassess);

}
