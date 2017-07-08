package com.chinasofti.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.base.Att;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.admin.AttService;

@Controller
@RequestMapping("/base/att")
public class AttController {
	@Autowired
	private AttService attService;
	@RequestMapping("/att.do")
	public String att() {
		return "/base/att";
	}
	@ResponseBody
	@RequestMapping("/datagrid.do")
	public DataGrid datagrid(Att att) {
		return this.attService.datagrid(att);
	}
}
