package com.chinasofti.controller.base;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.base.Afl;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.admin.AflService;

@Controller
@RequestMapping("/base/afl")
public class AflController {
	@Autowired
	private AflService aflService;
	@RequestMapping("/afl.do")
	public String afl() {
		return "/base/afl";
	}
	@RequestMapping("/aflAdd.do")
	public String aflAdd() {
		return "/base/aflAdd";
	}
	@RequestMapping("/aflEdit.do")
	public String aflEdit() {
		return "/base/aflEdit";
	}
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Afl afl) {
		return this.aflService.datagrid(afl);
	}
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Afl afl, HttpSession session) {
		Json json = new Json();
		try {
			this.aflService.add(afl, session);
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
	public Json edit(Afl afl, HttpSession session) {
		Json json = new Json();
		try {
			this.aflService.edit(afl, session);
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
	public Json remove(Afl afl) {
		Json json = new Json();
		try {
			this.aflService.remove(afl);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
}
