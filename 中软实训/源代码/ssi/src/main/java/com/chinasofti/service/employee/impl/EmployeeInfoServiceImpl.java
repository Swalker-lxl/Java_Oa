package com.chinasofti.service.employee.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.employee.EmployeeInfoMapper;
import com.chinasofti.model.employee.EmployeeInfo;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.employee.EmployeeInfoService;
import com.chinasofti.util.ToolUtil;
@Service("employeeInfoService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
	@Autowired
	private EmployeeInfoMapper employeeInfoMapper;

	@Override
	public DataGrid datagrid(EmployeeInfo emp) {
		DataGrid dataGrid = new DataGrid();
		emp.setPage((emp.getPage() - 1) * emp.getRows());
		dataGrid.setTotal(employeeInfoMapper.count(emp));
		dataGrid.setRows(employeeInfoMapper.selectList(emp));
		return dataGrid;
	}

	@Override
	public void add(EmployeeInfo emp, HttpSession session) {
		emp.setAddname((ToolUtil.user(session)));
		emp.setAddtime(new Date());
		employeeInfoMapper.insertSelective(emp);
	}

	@Override
	public void edit(EmployeeInfo emp, HttpSession session) {
		emp.setUpdatename(ToolUtil.user(session));
		emp.setUpdatetime(new Date());
		employeeInfoMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public void remove(EmployeeInfo emp) {
		String[] ids = emp.getIds().split(",");
		for (String id : ids) {
			employeeInfoMapper.deleteByPrimaryKey(id);
		}
	}
}
