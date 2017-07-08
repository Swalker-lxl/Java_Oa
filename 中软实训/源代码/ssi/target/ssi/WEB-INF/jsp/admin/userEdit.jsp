<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>账号</td>
			<td><input id="cid" name="cid"style="background-color: transparent; border: 0px; width: 150px;" readonly="readonly" style="width: 150px" ></td>
			<td>昵称</td>
			<td><input id="cname" name="cname" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input id="cpwd" name="cpwd" class="easyui-textbox" type="password" style="width: 150px" ></td>
			<td>重复</td>
			<td><input id="repwd" name="repwd" class="easyui-textbox" type="password" style="width: 150px" data-options="validType:'eqPassword[\'#cpwd\']'"></td>
		</tr>
	</table>
</form>