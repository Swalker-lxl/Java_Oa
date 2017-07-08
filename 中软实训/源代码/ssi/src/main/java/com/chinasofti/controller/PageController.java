package com.chinasofti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinasofti.model.admin.User;
import com.chinasofti.pageModel.Json;
import com.chinasofti.pageModel.UserInfo;
import com.chinasofti.service.admin.UserService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;

@Controller
@RequestMapping("/page")
public class PageController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/logout.do")
	public Json logout(HttpSession session) {
		Json json = new Json();
		session.invalidate();
		json.setSuccess(true);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public Json login(User user, HttpServletRequest req, HttpSession session) {
		Json json = new Json();
		User u = this.userService.query(user);
		if (u != null && u.getCpwd().equals(Md5Util.md5(user.getCpwd()))) {
			json.setSuccess(true);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(u.getCid());
			userInfo.setUserName(u.getCname());
			userInfo.setIp(ToolUtil.getIpAddr(req));
			session.setAttribute("userInfo", userInfo);
		} else {
			json.setSuccess(false);
			json.setMsg("用户名或密码错误");
		}
		return json;
	}

	@RequestMapping("/noSession.do")
	public String noSession() {
		return "noSession";
	}

}
