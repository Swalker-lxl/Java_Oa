<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>KPI名称</td>
			<td><input id="pername" name="pername" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>KPI考核点</td>
			<td><input id="percontent" name="percontent" class="easyui-textbox" style="width: 150px" data-options="required:true"> </td>
			<td>岗位</td>
			<td><input id="post" name="post" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
        <tr>
			<td>是否启用</td>
			<td>
			<select id="flag" class="easyui-combobox" name="flag" style="width:200px;" data-options="required:true;editable:false;">   
    <option value="1">已启用</option>   
    <option value="0">未启用</option>    
</select> 
</td>
			<td>新增 人员</td>
			<td><input id="createname" name="createname" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
	</table>
</form>