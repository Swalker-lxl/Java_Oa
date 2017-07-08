package com.chinasofti.controller.admin;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinasofti.model.admin.User;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.admin.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user.do")
	public String user() {
		return "/admin/user";
	}

	@RequestMapping("/userAdd.do")
	public String userAdd() {
		return "/admin/userAdd";
	}

	@RequestMapping("/userEdit.do")
	public String userEdit() {
		return "/admin/userEdit";
	}

	@RequestMapping("/userInfo.do")
	public String userInfo() {
		return "/admin/userInfo";
	}

	@ResponseBody
	@RequestMapping("/editUserInfo.do")
	public Json editUserInfo(User user, HttpSession session) {
		Json json = new Json();
		this.userService.edit(user, session);
		json.setSuccess(true);
		json.setMsg("修改成功");
		return json;
	}

	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(User user, HttpSession session) {
		Json json = new Json();
		try {
			this.userService.add(user, session);
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
	public Json edit(User user, HttpSession session) {
		Json json = new Json();
		try {
			this.userService.edit(user, session);
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
	public Json remove(User user) {
		Json json = new Json();
		try {
			this.userService.remove(user);
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
	public DataGrid datagrid(User user) {
		return this.userService.datagrid(user);
	}

}
