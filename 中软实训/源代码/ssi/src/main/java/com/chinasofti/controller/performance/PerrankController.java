package com.chinasofti.controller.performance;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.performance.Kpi;
import com.chinasofti.model.performance.Perrank;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.performance.KpiService;
import com.chinasofti.service.performance.PerrankService;

@Controller
@RequestMapping("/performance/perrank")
public class PerrankController {
	@Autowired
	private PerrankService perrankService;

	@RequestMapping("/perrank.do")
	public String perrank() {
		return "/performance/perrank";
	}
	
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Perrank perrank) {	
		return this.perrankService.datagrid(perrank);
	}
	
	@RequestMapping("/perrankAdd.do")
	public String perrankAdd() {
		return "/performance/perrankAdd";
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Perrank perrank, HttpSession session) {
		Json json = new Json();
		try {
			this.perrankService.add(perrank, session);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败:" + e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/perrankEdit.do")
	public String perrankEdit() {
		return "/performance/perrankEdit";
	}
	
	@ResponseBody
	@RequestMapping("/edit.do")
	public Json edit(Perrank perrank, HttpSession session) {
		Json json = new Json();
		try {
			this.perrankService.edit(perrank, session);
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
	public Json remove(Perrank perrank) {
		Json json = new Json();
		try {
			this.perrankService.remove(perrank);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
	
}
