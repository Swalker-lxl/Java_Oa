package com.chinasofti.service.admin;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.base.Bt;
import com.chinasofti.pageModel.DataGrid;

public interface BtService {

	DataGrid datagrid(Bt bt);

	void add(Bt bt, HttpSession session);

	void edit(Bt bt, HttpSession session);

	void remove(Bt bt);

}
