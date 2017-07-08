package com.chinasofti.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.employee.EmployeeInfo;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.employee.EmployeeInfoService;

@Controller
@RequestMapping("/emp/connect")
public class ConnectController {
	@Autowired
	private EmployeeInfoService employeeInfoService;
	@RequestMapping("/connect.do")
	public String emlpoyee() {
		return "/employee/connectInfo";
	}
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(EmployeeInfo emp) {
		return this.employeeInfoService.datagrid(emp);
	}
}
