<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input id="id" name="id" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
			<td>员工工号</td>
			<td><input id="pname" name="pname" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>工资系数</td>
			<td><input id="coefficient" name="coefficient"
				class="easyui-textbox" style="width: 150px"
				data-options="required:true"></td>
			<td>新增人员</td>
			<td><input id="createname" name="createname" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
		</tr>
	</table>
</form>