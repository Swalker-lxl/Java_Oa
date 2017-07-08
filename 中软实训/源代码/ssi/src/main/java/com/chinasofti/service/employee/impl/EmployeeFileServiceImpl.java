package com.chinasofti.service.employee.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.employee.EmployeeFileMapper;
import com.chinasofti.model.employee.EmployeeFile;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.employee.EmployeeFileService;
import com.chinasofti.util.ToolUtil;
@Service("employeeFileService")
public class EmployeeFileServiceImpl implements EmployeeFileService {
	@Autowired
	private EmployeeFileMapper employeeFileMapper;

	@Override
	public DataGrid datagrid(EmployeeFile emp) {
		DataGrid dataGrid = new DataGrid();
		emp.setPage((emp.getPage() - 1) * emp.getRows());
		dataGrid.setTotal(employeeFileMapper.count(emp));
		dataGrid.setRows(employeeFileMapper.selectList(emp));
		return dataGrid;
	}

	@Override
	public void add(EmployeeFile emp, HttpSession session) {
		emp.setAddname((ToolUtil.user(session)));
		emp.setAddtime(new Date());
		employeeFileMapper.insertSelective(emp);
	}

	@Override
	public void edit(EmployeeFile emp, HttpSession session) {
		emp.setUpdatename(ToolUtil.user(session));
		emp.setUpdatetime(new Date());
		employeeFileMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public void remove(EmployeeFile emp) {
		String[] ids = emp.getIds().split(",");
		for (String id : ids) {
			employeeFileMapper.deleteByPrimaryKey(id);
		}
	}
}
