<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
	<table>
		<tr>
			<td>收件人</td>
			<td><input id="acceptid" name="acceptid" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			
			</tr>
			<tr>
			<td>主题</td>
			<td><input id="theme" name="theme" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>正文</td>
			<td><textarea id="content" name="content" rows="20" style="width: 200px" ></textarea></td>
			
		</tr>
	</table>
</form>