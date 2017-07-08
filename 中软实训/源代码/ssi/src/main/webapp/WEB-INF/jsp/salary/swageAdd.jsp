<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>工号</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>基本工资</td>
			<td><input id="basewage" name="basewage" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>绩效工资</td>
			<td><input id="meriwag" name="meriwag" class="easyui-textbox"  style="width: 150px" data-options="required:true"></td>
			<td>奖金</td>
			<td><input id="waward" name="waward" class="easyui-textbox"  style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>银行账号</td>
			<td><input id="wbank" name="wbank" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>等级</td>
			<td><input id="wrank" name="wrank" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
	</table>
</form>