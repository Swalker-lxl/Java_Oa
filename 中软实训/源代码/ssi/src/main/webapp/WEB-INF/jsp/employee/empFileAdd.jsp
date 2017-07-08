<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>档案编号</td>
			<td><input id="tid" name="tid" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>工号</td>
			<td><input id="id" name="id" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td>
				<input id="idnumber" name="idnumber" class="easyui-textbox" style="width: 150px" data-options="required:true">
			</td>
			<td>籍贯</td>
			<td><input id="rigin" name="rigin" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>学历</td>
			<td><input id="education" name="education" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>政治面貌</td>
			<td><input id="ps" name="ps" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>学位</td>
			<td><input id="degree" name="degree" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>毕业学校</td>
			<td><input id="school" name="school" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>专业</td>
			<td><input id="major" name="major" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
		<tr>
			<td>工作经历</td>
			<td><input id="workexp" name="workexp" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
			<td>家庭住址</td>
			<td><input id="homeadd" name="homeadd" class="easyui-textbox" style="width: 150px" data-options="required:true"></td>
		</tr>
	</table>
</form>