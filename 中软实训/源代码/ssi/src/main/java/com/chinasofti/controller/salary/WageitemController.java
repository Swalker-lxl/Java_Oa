package com.chinasofti.controller.salary;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.salary.wageitem;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.salary.WageitemService;

@Controller
@RequestMapping("/salary/wageitem")
public class WageitemController {
	@Autowired
	private WageitemService wageitemService;
	
	@RequestMapping("/wageitem.do")
	public String wageitem() {
		return "/salary/wageitem";
	}
	@RequestMapping("/wageAdd.do")
	public String userAdd() {
		return "/salary/wageAdd";
	}

	@RequestMapping("/wageEdit.do")
	public String userEdit() {
		return "/salary/wageEdit";
	}

@ResponseBody
@RequestMapping("/add.do")
public Json add(wageitem user, HttpSession session) {
	Json json = new Json();
	try {
		this.wageitemService.add(user, session);
		json.setSuccess(true);
		json.setMsg("新增成功");
	} catch (Exception e) {
		json.setSuccess(false);
		json.setMsg("新增失败:" + e.getMessage());
	}
	return json;
}

@ResponseBody
@RequestMapping("/edit.do")
public Json edit(wageitem user, HttpSession session) {
	Json json = new Json();
	try {
		this.wageitemService.edit(user, session);
		json.setSuccess(true);
		json.setMsg("修改成功");
	} catch (Exception e) {
		json.setSuccess(false);
		json.setMsg("修改失败:" + e.getMessage());
	}
	return json;
}

@ResponseBody
@RequestMapping("/remove.do")
public Json remove(wageitem user) {
	Json json = new Json();
	try {
		this.wageitemService.remove(user);
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
public DataGrid datagrid(wageitem user) {
	return this.wageitemService.datagrid(user);
}
}
