package com.chinasofti.controller.base;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.base.Bt;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.admin.BtService;

@Controller
@RequestMapping("/base/bt")
public class BtController {
	@Autowired
	private BtService btService;
	@RequestMapping("/bt.do")
	public String bt() {
		return "/base/bt";
	}
	@RequestMapping("/btAdd.do")
	public String btAdd() {
		return "/base/btAdd";
	}
	@RequestMapping("/btEdit.do")
	public String btEdit() {
		return "/base/btEdit";
	}
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Bt bt) {
		return this.btService.datagrid(bt);
	}
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Bt bt, HttpSession session) {
		Json json = new Json();
		try {
			this.btService.add(bt, session);
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
	public Json edit(Bt bt, HttpSession session) {
		Json json = new Json();
		try {
			this.btService.edit(bt, session);
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
	public Json remove(Bt bt) {
		Json json = new Json();
		try {
			this.btService.remove(bt);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}
}
