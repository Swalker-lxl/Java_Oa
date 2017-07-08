package com.chinasofti.controller.performance;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.performance.Perrank;
import com.chinasofti.model.performance.Perss;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.performance.PerrankService;
import com.chinasofti.service.performance.PerssService;

@Controller
@RequestMapping("/performance/perss")
public class PerssController {
	@Autowired
	private PerssService perssService;

	@RequestMapping("/perss.do")
	public String perrank() {
		return "/performance/perss";
	}
	
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Perss perss) {	
		return this.perssService.datagrid(perss);
	}
	
	@RequestMapping("/perssAdd.do")
	public String perssAdd() {
		return "/performance/perssAdd";

	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Perss perss, HttpSession session) {
		Json json = new Json();
		try {
			this.perssService.add(perss, session);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败:" + e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/perssEdit.do")
	public String perssEdit() {
		return "/performance/perssEdit";
	}
	
	@ResponseBody
	@RequestMapping("/edit.do")
	public Json edit(Perss perss, HttpSession session) {
		Json json = new Json();
		try {
			this.perssService.edit(perss, session);
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
	public Json remove(Perss perss) {
		Json json = new Json();
		try {
			this.perssService.remove(perss);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
}
