<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center" style="padding: 5px;">
	<form method="post">
		<table class="tableForm">
			<tr>
				<th>菜单名称</th>
				<td><input name="cname" class="easyui-textbox" data-options="required:true,missingMessage:'请填写菜单名称'" style="width: 155px;"/></td>
				<th>排序</th>
				<td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="3" style="width: 155px;" /></td>
			</tr>
			<tr>
				<th>菜单地址</th>
				<td colspan="3"><textarea name="curl" style="height: 50px; width: 97%;"></textarea></td>
			</tr>
			<tr>
				<th>上级菜单</th>
				<td><input name="cpid" style="width: 160px;" data-options="required:true"/></td>
				<th>菜单图标</th>
				<td><input name="ciconcls" style="width: 155px;" /></td>
			</tr>
		</table>
	</form>
</div>