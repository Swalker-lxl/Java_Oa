<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center" style="padding: 5px;">
	<form method="post">
		<table class="tableForm">
			<tr>
				<th>部门名称</th>
				<td><input name="pname" class="easyui-textbox" data-options="required:true,missingMessage:'请填写部门名称'" style="width: 155px;"/></td>
				<th>排序</th>
				<td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择部门排序'" value="3" style="width: 155px;" /></td>
			</tr>
			<tr>
				<th>部门信息</th>
				<td colspan="3"><textarea name="message" style="height: 50px; width: 97%;"></textarea></td>
			</tr>
			<tr>
				<th>上级部门</th>
				<td><input name="cpid" style="width: 160px;" data-options="required:true"/></td>
				<th>部门图标</th>
				<td><input name="pidconcls" style="width: 155px;" /></td>
			</tr>
		</table>
	</form>
</div>