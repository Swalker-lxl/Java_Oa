<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
		<tr>
			<td>编号</td>
			<td><input id="id" name="id" style="background-color: transparent; border: 0px; width: 150px;" readonly="readonly" style="width: 150px"></td>
			<td>名称</td>
			<td><input id="fname" name="fname" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>比例</td>
			<td><input id="scale" name="scale" class="easyui-textbox"  style="width: 150px" data-options="required:true"></td>
			<td>重复</td>
			<td><input id="fiveandoneAdd" name="scale" class="easyui-textbox" style="width: 150px" data-options="validType:'eqPassword[\'#scale\']'"></td>
		</tr>
	</table>
</form>