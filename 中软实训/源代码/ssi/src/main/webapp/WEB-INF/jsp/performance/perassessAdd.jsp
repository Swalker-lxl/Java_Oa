<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input id="id" name="id" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
			<td>工号</td>
			<td><input id="uid" name="uid" class="easyui-textbox"
				type="text" style="width: 150px" required="required" /></td>

		</tr>

		<tr>

			<td>绩效时间</td>
			<td><input id="monthtime" name="monthtime"
				class="easyui-datebox" type="text" style="width: 150px"
				required="required" /></td>
			<td>绩效成绩</td>
			<td><input id="perrank" name="perrank" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>

		</tr>

		<tr>

			<td>审批人</td>
			<td><input id="asspeople" name="asspeople" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
			<td>审批时间</td>
			<td><input id="asstime" name="asstime"
				class="easyui-datebox" type="text" style="width: 150px"
				required="required" /></td>
		</tr>
		<tr>

			<td>新增人员</td>
			<td><input id="createname" name="createname" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
		</tr>

	</table>



</form>