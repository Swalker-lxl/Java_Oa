package com.chinasofti.service.admin;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.base.Afl;
import com.chinasofti.pageModel.DataGrid;

public interface AflService {

	DataGrid datagrid(Afl afl);

	void add(Afl afl, HttpSession session);

	void edit(Afl afl, HttpSession session);

	void remove(Afl afl);


}
