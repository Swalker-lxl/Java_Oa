package com.chinasofti.controller.performance;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.performance.Kpi;
import com.chinasofti.model.performance.Perassess;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.performance.KpiService;
import com.chinasofti.service.performance.PerassessService;

@Controller
@RequestMapping("/performance/perassess")
public class PerassessController {

	@Autowired
	private PerassessService perassessService;
	
	@RequestMapping("/perassess.do")
	public String perassess() {
		return "/performance/perassess";
	}

	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Perassess perassess) {	
		return this.perassessService.datagrid(perassess);
	}
	
	@RequestMapping("/perassessAdd.do")
	public String perassessAdd() {
		return "/performance/perassessAdd";
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Perassess perassess, HttpSession session) {
		Json json = new Json();
		try {
			this.perassessService.add(perassess, session);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败:" + e.getMessage());
		}
		return json;
	}
	@RequestMapping("/perassessEdit.do")
	public String perassessEdit() {
		return "/performance/perassessEdit";
	}
	@ResponseBody
	@RequestMapping("/edit.do")
	public Json edit(Perassess perassess, HttpSession session) {
		Json json = new Json();
		try {
			this.perassessService.edit(perassess, session);
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
	public Json remove(Perassess perassess) {
		Json json = new Json();
		try {
			this.perassessService.remove(perassess);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
}
