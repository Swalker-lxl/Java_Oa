<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input id="id" name="id" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
			<td>工号</td>
			<td><input id="uid" name="uid"
				class="easyui-textbox" type="text" style="width: 150px"
				required="required" /></td>

		</tr>

		<tr>
			<td>计划</td>
			<td><input id="plan" name="plan" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
			<td>绩效时间</td>
			<td><input id="monthtime" name="monthtime"
				class="easyui-datebox" type="text" style="width: 150px"
				required="required" /></td>

		</tr>

		<tr>
			<td>KPI考点</td>
			<td><input id="kid" name="kid"
				class="easyui-textbox" style="width: 150px"
				data-options="required:true"></td>
			<td>新增人员</td>
			<td><input id="createname" name="createname"
				class="easyui-textbox" style="width: 150px"
				data-options="required:true"></td>

		</tr>

	</table>



</form>