package com.chinasofti.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinasofti.model.admin.Menu;
import com.chinasofti.pageModel.Json;
import com.chinasofti.pageModel.TreeNode;
import com.chinasofti.service.admin.MenuService;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping("/menu.do")
	public String menu() {
		return "/admin/menu";
	}

	@RequestMapping("/menuAdd.do")
	public String menuAdd() {
		return "/admin/menuAdd";
	}

	@RequestMapping("/menuEdit.do")
	public String menuEdit() {
		return "/admin/menuEdit";
	}

	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Menu record) {
		Json json = new Json();
		try {
			this.menuService.insertSelective(record);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("新增失败");
		}
		return json;
	}

	@ResponseBody
	@RequestMapping("/edit.do")
	public Json edit(Menu record) {
		Json json = new Json();
		try {
			this.menuService.updateByPrimaryKeySelective(record);
			json.setSuccess(true);
			json.setMsg("修改成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("修改失败");
		}
		return json;
	}

	@ResponseBody
	@RequestMapping("/remove.do")
	public Json remove(HttpServletRequest req) {
		Json json = new Json();
		try {
			String cid = req.getParameter("cid");
			this.menuService.deleteById(cid);
			json.setSuccess(true);
			json.setMsg("删除成功");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}

	@ResponseBody
	@RequestMapping("/notNeedAuth_menuTree.do")
	public List<TreeNode> menuTree(HttpSession session) {
		List<TreeNode> treeNodeList = this.menuService.menuTree();
		return treeNodeList;
	};

	@ResponseBody
	@RequestMapping("/treegrid.do")
	public List<Menu> treegrid() {
		return this.menuService.treegrid();
	}

}
