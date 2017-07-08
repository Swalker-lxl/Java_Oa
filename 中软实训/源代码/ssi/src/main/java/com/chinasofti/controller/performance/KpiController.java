package com.chinasofti.controller.performance;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.performance.Kpi;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.performance.KpiService;

@Controller
@RequestMapping("/performance/kpi")
public class KpiController {
	
	@Autowired
	private KpiService kpiService;
	
	@RequestMapping("/kpi.do")
	public String kpi() {
		return "/performance/kpi";
	}

	@RequestMapping("/kpiAdd.do")
	public String kpiAdd() {
		return "/performance/kpiAdd";
	}
	
	@RequestMapping("/kpiEdit.do")
	public String kpiEdit() {
		return "/performance/kpiEdit";
	}
	
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Kpi kpi) {	
		return this.kpiService.datagrid(kpi);
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Kpi kpi, HttpSession session) {
		Json json = new Json();
		try {
			this.kpiService.add(kpi, session);
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
	public Json edit(Kpi kpi, HttpSession session) {
		Json json = new Json();
		try {
			this.kpiService.edit(kpi, session);
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
	public Json remove(Kpi kpi) {
		Json json = new Json();
		try {
			this.kpiService.remove(kpi);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
	
}
