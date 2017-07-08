<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>工号</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>姓名</td>
			<td><input id="addname" name="addname" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>请假编号</td>
			<td><input id="aflid" name="aflid" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		    <td>请假类型</td>
			<td><input id="afltype" name="afltype" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
		    <td>请假说明</td>
			<td><input id="btexplan" name="btexplan" class="easyui-textbox"  style="width: 150px" data-options="required:true"></td>
			<td>审批人</td>
			<td><select id="btapprover" name="btapprover" class="easyui-combobox" style="width: 150px" data-options="editable:false">
			       <option value="admin">admin</option>
			       <option value="user">user</option>
			      </select></td>
		</tr>
		<tr>
			<td>请假起时</td>
			<td><input id="aflstime" name="aflstime" class="easyui-datebox" style="width: 150px" data-options="required:true"></td>
		    <td>请假止时</td>
			<td><input id="faletime" name="faletime" class="easyui-datebox" style="width: 150px" data-options="required:true"></td>
		</tr>
	</table>
</form>