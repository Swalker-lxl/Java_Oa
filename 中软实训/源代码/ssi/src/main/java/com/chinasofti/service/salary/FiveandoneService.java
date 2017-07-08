package com.chinasofti.service.salary;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.salary.Fiveandone;
import com.chinasofti.pageModel.DataGrid;

public interface FiveandoneService {


	DataGrid datagrid(Fiveandone fiveandone);

	void add(Fiveandone fiveandone, HttpSession session);

	void edit(Fiveandone fiveandone, HttpSession session);

	void remove(Fiveandone fiveandone);

}
