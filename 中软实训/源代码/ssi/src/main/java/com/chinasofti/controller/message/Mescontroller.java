package com.chinasofti.controller.message;

import java.net.URI;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.admin.User;
import com.chinasofti.model.message.Mes;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.message.MesService;

@Controller
@RequestMapping("/message/mes")
public class Mescontroller {
	@Autowired
	private MesService mesService;
	
	@RequestMapping("/mesAdd.do")
	public String userAdd() {
		return "/layout/mesAdd";
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Mes message, HttpSession session) {
		Json json = new Json();
		try {
			this.mesService.add(message, session);
			json.setSuccess(true);
			json.setMsg("发送成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("发送失败:" + e.getMessage());
		}
		return json;
	}
	@ResponseBody
	@RequestMapping("/edit.do")
	public Json edit(Mes message, HttpSession session) {
		Json json = new Json();
		try {
			this.mesService.edit(message, session);
			json.setSuccess(true);
			json.setMsg("标记成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("标记失败:" + e.getMessage());
		}
		return json;
	}
	@ResponseBody
	@RequestMapping("/remove.do")
	public Json remove(Mes message) {
		Json json = new Json();
		try {
			this.mesService.remove(message);
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
	public DataGrid datagrid(Mes message,HttpSession session) {
		return this.mesService.datagrid(message,session);
	}

}
