<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>工号</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>基本工资</td>
			<td><input id="fname" name="fname" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>绩效工资</td>
			<td><input id="scale" name="scale" class="easyui-textbox"  style="width: 150px" data-options="required:true"></td>
			<td>奖金</td>
			<td><input id="scale" name="scale" class="easyui-textbox"  style="width: 150px" data-options="required:true"></td>
			<td>银行账号</td>
			<td><input id="fiveandoneAdd" name="scale" class="easyui-textbox" style="width: 150px" data-options="required:true,validType:'eqScale[\'#scale\']'"></td>
		</tr>
	</table>
</form>