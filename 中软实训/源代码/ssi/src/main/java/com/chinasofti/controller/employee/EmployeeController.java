package com.chinasofti.controller.employee;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.model.employee.EmployeeInfo;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.Json;
import com.chinasofti.service.employee.EmployeeInfoService;

@Controller
@RequestMapping("/emp/employee")
public class EmployeeController {
	@Autowired
	private EmployeeInfoService employeeInfoService;
	@RequestMapping("/employee.do")
	public String emlpoyee() {
		return "/employee/employeeInfo";
	}
	@RequestMapping("/empAdd.do")
	public String userAdd() {
		return "/employee/empAdd";
	}
	@RequestMapping("/userEdit.do")
	public String userEdit() {
		return "/employee/empEdit";
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public Json add(@RequestParam("upload") MultipartFile upload,EmployeeInfo emp,HttpServletRequest request, HttpSession session) {
		Json json = new Json();
		String fileName = upload.getOriginalFilename();
		try {
			if(!upload.isEmpty()){
				// 将商品图片上传到服务器上.
				// 获得上传图片的服务器端路径.
				String path = request.getSession().getServletContext().getRealPath(
						"/photos");
				String newFileName = new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
				// 创建文件类型对象:
				File diskFile = new File(path + "//" + newFileName);
				// 文件上传:
				//FileUtils.copyFile(upload, diskFile);
				upload.transferTo(diskFile);
		
				emp.setPhoto("photos/" + newFileName);
			}
			this.employeeInfoService.add(emp, session);
			json.setSuccess(true);
			json.setMsg("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("新增失败:" + e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/edit.do")
	public Json editUserInfo(@RequestParam("upload") MultipartFile upload,EmployeeInfo emp,HttpServletRequest request, HttpSession session) {
		Json json = new Json();
		String fileName = upload.getOriginalFilename();
		try {
			if(!upload.isEmpty()){
				// 将商品图片上传到服务器上.
				// 获得上传图片的服务器端路径.
				String path = request.getSession().getServletContext().getRealPath(
						"/photos");
				String newFileName = new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
				// 创建文件类型对象:
				File diskFile = new File(path + "//" + newFileName);
				// 文件上传:
				//FileUtils.copyFile(upload, diskFile);
				upload.transferTo(diskFile);
		
				emp.setPhoto("photos/" + newFileName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		this.employeeInfoService.edit(emp, session);
		json.setSuccess(true);
		json.setMsg("修改成功");
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/remove.do")
	public Json remove(EmployeeInfo emp) {
		Json json = new Json();
		try {
			this.employeeInfoService.remove(emp);
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
	public DataGrid datagrid(EmployeeInfo emp) {
		return this.employeeInfoService.datagrid(emp);
	}
}
