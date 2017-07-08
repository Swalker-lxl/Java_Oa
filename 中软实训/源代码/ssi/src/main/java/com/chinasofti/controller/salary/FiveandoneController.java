package com.chinasofti.controller.salary;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.salary.Fiveandone;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.salary.FiveandoneService;

@Controller
@RequestMapping("/salary/fiveandone")

public class FiveandoneController {
	@Autowired
	private FiveandoneService fiveandoneService;
	
	@RequestMapping("/fiveandone.do")
	public String fiveandone() {
		return "/salary/fiveandone";
	}
	@RequestMapping("/fiveandoneAdd.do")
	public String fiveandoneAdd() {
		return "/salary/fiveandoneAdd";
	}
	@RequestMapping("/fiveandoneEdit.do")
	public String fiveandoneEdit() {
		return "/salary/fiveandoneEdit";
	}
	
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Fiveandone fiveandone) {
		return this.fiveandoneService.datagrid(fiveandone);
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Fiveandone fiveandone, HttpSession session) {
		Json json = new Json();
		try {
			this.fiveandoneService.add(fiveandone, session);
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
	public Json edit(Fiveandone fiveandone, HttpSession session) {
		Json json = new Json();
		try {
			this.fiveandoneService.edit(fiveandone, session);
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
	public Json remove(Fiveandone fiveandone) {
		Json json = new Json();
		try {
			this.fiveandoneService.remove(fiveandone);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
}
