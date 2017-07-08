package com.chinasofti.controller.structure;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.structure.Dep;
import com.chinasofti.model.structure.Pos;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.structure.PosService;



@Controller
@RequestMapping("/structure/post")
public class PosController {
	@Autowired
	private PosService posService;
	@RequestMapping("/post.do")
	public String post() {
		return "/structure/post";
	}
	@RequestMapping("/postAdd.do")
	public String userAdd() {
		return "/structure/postAdd";
	}
	@RequestMapping("/postEdit.do")
	public String userEdit() {
		return "/structure/postEdit";
	}
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Pos post) {
		return this.posService.datagrid(post);
	}
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Pos post, HttpSession session) {
		Json json = new Json();
		try {
			this.posService.add(post, session);
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
	public Json edit(Pos post, HttpSession session) {
		Json json = new Json();
		try {
			this.posService.edit(post, session);
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
	public Json remove(Pos post) {
		Json json = new Json();
		try {
			this.posService.remove(post);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败:" + e.getMessage());
		}
		return json;
	}

}
