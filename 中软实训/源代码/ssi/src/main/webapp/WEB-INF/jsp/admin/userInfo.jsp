<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div data-options="region:'center',title:'个人信息'" style="overflow: hidden; padding: 5px;">
	<form id="userInfoForm" method="post">
		<input name="cid" type="hidden" value="${userInfo.userId}" />
		<table class="tableForm">
			<tr>
				<th style="width: 55px;" align="left">账 号</th>
				<td><input value="${userInfo.userId}" style="background-color: transparent; border: 0px; width: 150px;" readonly="readonly" /></td>
			</tr>
			<tr>
				<th style="width: 55px;" align="left">昵 称</th>
				<td><input value="${userInfo.userName}" style="background-color: transparent; border: 0px; width: 150px;" readonly="readonly" /></td>
			</tr>
			<tr>
				<th align="left">登录IP</th>
				<td><input style="background-color: transparent; border: 0px; width: 200px;" value="${userInfo.ip}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th align="left">修改密码</th>
				<td><input name="cpwd" type="password" class="easyui-textbox" data-options="required:'true',missingMessage:'请填写修改密码'" style="width: 200px;" /></td>
			</tr>
			<tr>
				<th align="left">确认密码</th>
				<td><input type="password" class="easyui-textbox" data-options="required:'true',missingMessage:'请再次填写密码',validType:'eqPassword[\'#userInfoForm input[name=cpwd]\']'" style="width: 200px;" /></td>
			</tr>
		</table>
	</form>
</div>
