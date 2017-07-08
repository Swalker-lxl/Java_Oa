package com.chinasofti.controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.employee.Job;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.employee.JobService;

@Controller
@RequestMapping("/emp/job")
public class JobController {
	@Autowired
	private JobService jobService;
	@RequestMapping("/job.do")
	public String job() {
		return "/employee/jobInfo";
	}
	@RequestMapping("/jobAdd.do")
	public String jobAdd() {
		return "/employee/jobAdd";
	}
	@RequestMapping("/jobEdit.do")
	public String jobEdit() {
		return "/employee/jobEdit";
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Job job,HttpSession session) {
		Json json = new Json();
		try {
			this.jobService.add(job, session);
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
	public Json editJobInfo(Job job, HttpSession session) {
		Json json = new Json();
		this.jobService.edit(job, session);
		json.setSuccess(true);
		json.setMsg("修改成功");
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/remove.do")
	public Json remove(Job job) {
		Json json = new Json();
		try {
			this.jobService.remove(job);
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
	public DataGrid datagrid(Job job) {
		return this.jobService.datagrid(job);
	}
}
