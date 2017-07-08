package com.chinasofti.controller.salary;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinasofti.model.salary.Swage;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.salary.SwageService;

@Controller
@RequestMapping("/salary/swage")
public class SwageController {

	@Autowired
	private SwageService swageService;

	@RequestMapping("/swage.do")
	public String user() {
		return "/salary/swage";
	}

	@RequestMapping("/swageAdd.do")
	public String userAdd() {
		return "/salary/swageAdd";
	}

	@RequestMapping("/swageEdit.do")
	public String userEdit() {
		return "/salary/swageEdit";
	}

	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Swage user, HttpSession session) {
		Json json = new Json();
		try {
			this.swageService.add(user, session);
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
	public Json edit(Swage user, HttpSession session) {
		Json json = new Json();
		try {
			this.swageService.edit(user, session);
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
	public Json remove(Swage user) {
		Json json = new Json();
		try {
			this.swageService.remove(user);
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
	public DataGrid datagrid(Swage user) {
		return this.swageService.datagrid(user);
	}

}
