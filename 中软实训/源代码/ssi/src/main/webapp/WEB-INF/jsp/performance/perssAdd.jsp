<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input id="id" name="id" class="easyui-textbox"
				style="width: 150px" data-options="required:true"></td>
			<td>绩效时间</td>
			<td><input id="monthtime" name="monthtime"
				class="easyui-datebox" type="text" style="width: 150px"
				required="required" /></td>

		</tr>

		<tr>
			<td>新增人员</td>
			<td><input id="createname" name="createname"
				class="easyui-textbox" style="width: 150px"
				data-options="required:true"></td>
			<td>是否启用</td>
			<td><select id="state" class="easyui-combobox" name="state"
				style="width: 100px;"  >
					<option value="1">已启用</option>
					<option value="0">未启用</option>
			</select></td>
		</tr>

	</table>



</form>