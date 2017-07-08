package com.chinasofti.service.performance;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.performance.Perrank;
import com.chinasofti.pageModel.DataGrid;

public interface PerrankService {

	DataGrid datagrid(Perrank perrank);

	void add(Perrank perrank, HttpSession session);

	void edit(Perrank perrank, HttpSession session);

	void remove(Perrank perrank);

}
