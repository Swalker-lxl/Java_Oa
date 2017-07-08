<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>工号</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" readonly="readonly"></td>
			<td>姓名</td>
			<td><input id="name" name="name" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<select id="sex" class="easyui-combobox" name="sex" style="width:150px;">   
				    <option value="1">男</option>   
				    <option value="0">女</option>   
				</select>  
			</td>
			<td>照片</td>
			<td><input id="upload" name="upload" class="easyui-filebox" style="width:150px"></td>
		</tr>
		<tr>
			<td>部门</td>
			<td><input id="depart" name="depart" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>职位</td>
			<td><input id="position" name="position" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>岗位</td>
			<td><input id="station" name="station" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>办公地点</td>
			<td><input id="location" name="location" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input id="pnumber" name="pnumber" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>电子邮件</td>
			<td><input id="email" name="email" class="easyui-validatebox" style="width: 150px" data-options="required:true,validType:'email'"></td>
		</tr>
		<tr>
			<td>入职时间</td>
			<td>
				<input  id="hiredate" name="hiredate" class="easyui-datetimebox" data-options="required:true,showSeconds:true"  style="width:150px">  
			</td>
			<td>离职时间</td>
			<td>
				<input  id="leavedate" name="leavedate" class="easyui-datetimebox" data-options="required:true,showSeconds:true"  style="width:150px">  
			</td>
		</tr>
	</table>
</form>