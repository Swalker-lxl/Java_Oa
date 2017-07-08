<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/salary/wageitem/datagrid.do',
			fit : true,
			striped : true,
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 20,
			pageList : [ 20, 40, 60, 80, 100 ],
			idField : 'waid',
			sortName : 'waid',
			sortOrder : 'asc',
			frozenColumns : [ [ {
				checkbox : true,
				title : '',
				field : ''
			}, {
				field : 'waid',
				title : '工号',
				width : 80,
				sortable : true
			}, {
				field : 'wuid',
				title : '姓名',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'basewage',
				title : '基本工资',
				width : 80,
			}, {
				field : 'meritwage',
				title : '绩效工资',
				width : 80
			}, {
				field : 'bouns',
				title : '奖金',
				width : 80
			}, {
				field : 'deductions',
				title : '扣税',
				width : 80
			},  {
				field : 'dedfiveone',
				title : '五险一金',
				width : 80
			},{
 				field : 'deductions',
				title : '奖惩',
				width : 80
			}, {
				field : 'wagetime',
				title : '薪资年月',
				width : 100
			} , {
				field : 'shsend',
				title : '应发金额',
				width : 100
			} , {
				field : 'realsend',
				title : '实发金额',
				width : 100
			} ] ]
		});
	});

	function query() {
		datagrid.datagrid('load', {
			wuid : $("#waid").val(),
			wagetime : $("#wagetime").val(),
			wuid : $("#wuid").val()
		});

	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'过滤条件',split:true, iconCls:'icon-search'" style="height: 65px;">
		<table>
			<tr>
				<td>工号 :<input id="waid" class="easyui-textbox" style="width: 100px"> 薪资年月 : <input id="wagetime" class="easyui-textbox" style="width: 150px"> <td>姓名 :<input id="wuid" class="easyui-textbox" style="width: 100px"><a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'工资列表', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>