package com.chinasofti.controller.employee;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.employee.EmployeeFile;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.employee.EmployeeFileService;

@Controller
@RequestMapping("/emp/empFile")
public class EmployeeFileController {
	@Autowired
	private EmployeeFileService employeeFileService;
	@RequestMapping("/empFile.do")
	public String emlpoyee() {
		return "/employee/empFileInfo";
	}
	@RequestMapping("/empFileAdd.do")
	public String userAdd() {
		return "/employee/empFileAdd";
	}
	@RequestMapping("/empFileEdit.do")
	public String userEdit() {
		return "/employee/empFileEdit";
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(EmployeeFile emp,HttpSession session) {
		Json json = new Json();
		try {
			this.employeeFileService.add(emp, session);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("新增失败:" + e.getMessage());
		}
		return json;
	}

	@ResponseBody
	@RequestMapping("/edit.do")
	public Json editUserInfo(EmployeeFile emp, HttpSession session) {
		Json json = new Json();
		this.employeeFileService.edit(emp, session);
		json.setSuccess(true);
		json.setMsg("修改成功");
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/remove.do")
	public Json remove(EmployeeFile emp) {
		Json json = new Json();
		try {
			this.employeeFileService.remove(emp);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(EmployeeFile emp) {
		return this.employeeFileService.datagrid(emp);
	}
}
