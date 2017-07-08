<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>工号</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>姓名</td>
			<td><input id="name" name="name" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>出差编号</td>
			<td><input id="btid" name="btid" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		    <td>说明</td>
			<td><input id="btexplain" name="btexplain" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>出差地点</td>
			<td><input id="btplace" name="btplace" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		    <td>交通工具</td>
			<td><input id="btvehicle" name="btvehicle" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>审批人</td>
			<td><select id="btapprover" name="btapprover" class="easyui-combobox" style="width: 150px" data-options="editable:false">
			       <option value="admin">admin</option>
			       <option value="user">user</option>
			      </select></td>
	        <td>审批状态</td>
			<td><select id="attappss" name="attappss" class="easyui-combobox" style="width: 150px" data-options="editable:false">
			       <option value="待批">待批</option>
			      </select></td>
		</tr>
		<tr>
			<td>出差起时</td>
			<td><input id="btsdate" name="btsdate" class="easyui-datebox" style="width: 150px" data-options="required:true"></td>
		    <td>出差止时</td>
			<td><input id="btedate" name="btedate" class="easyui-datebox" style="width: 150px" data-options="required:true"></td>
		</tr>
	</table>
</form>