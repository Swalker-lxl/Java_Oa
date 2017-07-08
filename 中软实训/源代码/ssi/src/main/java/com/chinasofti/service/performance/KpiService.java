package com.chinasofti.service.performance;

import javax.servlet.http.HttpSession;

import com.chinasofti.model.performance.Kpi;
import com.chinasofti.pageModel.DataGrid;

public interface KpiService {

	DataGrid datagrid(Kpi kpi);

	void add(Kpi kpi, HttpSession session);

	void edit(Kpi kpi, HttpSession session);

	void remove(Kpi kpi);

}
