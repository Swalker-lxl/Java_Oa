<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/emp/connect/datagrid.do',
			fit : true,
			striped : true,
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 20,
			pageList : [ 20, 40, 60, 80, 100 ],
			idField : 'id',
			sortName : 'id',
			sortOrder : 'asc',
			frozenColumns : [ [ {
				checkbox : true,
				title : '',
				field : ''
			}, {
				field : 'id',
				title : '工号',
				width : 100,
				sortable : true
			}, {
				field : 'name',
				title : '名字',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [  {
				field : 'sex',
				title : '性别',
				width : 150
			}, {
				field : 'photo',
				title : '照片',
				width : 68,
				formatter : function(value, rowData, rowIndex) {
					return "<img width='68' height='80' src='${pageContext.request.contextPath}/"+value+"' />";
				}
			}, {
				field : 'depart',
				title : '部门',
				width : 150
			}, {
				field : 'position',
				title : '岗位',
				width : 150
			}, {
				field : 'station',
				title : '职位',
				width : 150
			}, {
				field : 'location',
				title : '办公地点',
				width : 150
			}, {
				field : 'pnumber',
				title : '电话',
				width : 150
			}, {
				field : 'email',
				title : '邮箱',
				width : 150
			} ] ]
			
		});
	});


	function query() {
		datagrid.datagrid('load', {
			id : $("#id").val(),
			name : $("#name").val()
		});

	}

	
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'检索条件',split:true, iconCls:'icon-search'" style="height: 65px;">
		<table>
			<tr>
				<td>工号:<input id="id" class="easyui-textbox" style="width: 150px"> 姓名: <input id="name" class="easyui-textbox" style="width: 150px"> <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'用户列表', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>