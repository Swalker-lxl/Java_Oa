package com.chinasofti.controller.performance;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.performance.Kpi;
import com.chinasofti.model.performance.Workplan;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.performance.KpiService;
import com.chinasofti.service.performance.WorkplanService;

@Controller
@RequestMapping("/performance/workplan")
public class WorkplanController {
	@Autowired
	private WorkplanService workplanService;

	@RequestMapping("/workplan.do")
	public String kpi() {
		return "/performance/workplan";
	}

	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Workplan workplan) {
		return this.workplanService.datagrid(workplan);
	}

	@RequestMapping("/workplanAdd.do")
	public String workplanAdd() {
		return "/performance/workplanAdd";
	}

	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Workplan workplan, HttpSession session) {
		Json json = new Json();
		try {
			this.workplanService.add(workplan, session);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败:" + e.getMessage());
		}
		return json;
	}

	@RequestMapping("/workplanEdit.do")
	public String workplanEdit() {
		return "/performance/workplanEdit";
	}

	@ResponseBody
	@RequestMapping("/edit.do")
	public Json edit(Workplan workplan, HttpSession session) {
		Json json = new Json();
		try {
			this.workplanService.edit(workplan, session);
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
	public Json remove(Workplan workplan) {
		Json json = new Json();
		try {
			this.workplanService.remove(workplan);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}

}
