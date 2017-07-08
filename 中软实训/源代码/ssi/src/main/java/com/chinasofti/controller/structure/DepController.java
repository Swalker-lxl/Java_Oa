package com.chinasofti.controller.structure;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.model.admin.Menu;
import com.chinasofti.model.structure.Dep;
import com.chinasofti.pageModel.Json;
import com.chinasofti.pageModel.TreeNode;
import com.chinasofti.service.structure.DepService;



@Controller
@RequestMapping("/structure/dept")
public class DepController {
	@Autowired
	private DepService depService;
	@RequestMapping("/dept.do")
	public String dept() {
		return "/structure/dept";
	}
	@RequestMapping("/deptAdd.do")
	public String menuAdd() {
		return "/structure/deptAdd";
	}

	@RequestMapping("/deptEdit.do")
	public String menuEdit() {
		return "/structure/deptEdit";
	}

	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(Dep record) {
		Json json = new Json();
		try {
			this.depService.insertSelective(record);
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
	public Json edit(Dep record) {
		Json json = new Json();
		try {
			this.depService.updateByPrimaryKeySelective(record);
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
			String pid = req.getParameter("pid");
			this.depService.deleteById(pid);
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
		List<TreeNode> treeNodeList = this.depService.menuTree();
		return treeNodeList;
	};

	@ResponseBody
	@RequestMapping("/treegrid.do")
	public List<Dep> treegrid() {
		return this.depService.treegrid();
	}
}
