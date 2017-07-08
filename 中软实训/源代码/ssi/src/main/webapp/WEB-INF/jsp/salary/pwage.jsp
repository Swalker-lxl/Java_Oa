<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/salary/pwage/datagrid.do',
			fit : true,
			striped : true,
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 20,
			pageList : [ 20, 40, 60, 80, 100 ],
			idField : 'id',
			sortName : 'wagetime',
			sortOrder : 'asc',
			frozenColumns : [ [ {
				checkbox : true,
				title : '',
				field : ''
			}, {
				field : 'wagetime',
				title : '薪资年月',
				width : 150,
				sortable : true
			}] ],
			columns : [ [ {
				field : 'state',
				title : '发放状态',
				width : 150,
			}] ],
			toolbar : [ {
				iconCls : 'icon-edit',
				text : '发放本月薪资',
				handler : function() {
					add();
				}
			}]

		});
	});

	function add() {
		var rows = datagrid.datagrid('getChecked');
		if (rows.length == 1) {
			var p = parent.js.dialog({
				title : '新增',
				width : 400,
				height : 150,
				closed : false,
				cache : false,
				href : '${pageContext.request.contextPath}/salary/pwage/pwageAdd.do',
				modal : true,
				buttons : [ {
					text : '修改',
					handler : function() {
						var f = p.find("form");
						f.form('submit', {
							url : '${pageContext.request.contextPath}/salary/pwage/Add.do',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									p.dialog("close");
									query();
									datagrid.datagrid('unselectAll');
								}
								parent.$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
							});
					}
				} ],
				onLoad : function() {
					var f = p.find("form");
					f.form('load', {
						wagetime : rows[0].wagetime,
						state : rows[0].state
					});
				}
			});
		} else if (rows.length > 1) {
			parent.$.messager.alert('提示', '只能修改一条记录！', 'error');
		} else {
			parent.$.messager.alert('提示', '请选择要修改的记录！', 'error');
		}
	}
	function edit() {
		var rows = datagrid.datagrid('getChecked');
		if (rows.length == 1) {
			var p = parent.js.dialog({
				title : '修改',
				width : 400,
				height : 150,
				closed : false,
				cache : false,
				href : '${pageContext.request.contextPath}/admin/user/userEdit.do',
				modal : true,
				buttons : [ {
					text : '修改',
					handler : function() {
						var f = p.find("form");
						f.form('submit', {
							url : '${pageContext.request.contextPath}/admin/user/edit.do',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									p.dialog("close");
									query();
									datagrid.datagrid('unselectAll');
								}
								parent.$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
						});
					}
				} ],
				onLoad : function() {
					var f = p.find("form");
					f.form('load', {
						wagetime : rows[0].wagetime,
						state : rows[0].state
					});
				}
			});
		} else if (rows.length > 1) {
			parent.$.messager.alert('提示', '只能修改一条记录！', 'error');
		} else {
			parent.$.messager.alert('提示', '请选择要修改的记录！', 'error');
		}
	}

	function query() {
		datagrid.datagrid('load', {
			wagetime : $("#wagetime").val(),
			state : $("#state").val()
		});

	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'过滤条件',split:true, iconCls:'icon-search'" style="height: 65px;">
		<table>
			<tr>
				<td>薪资年月:<input id="wagetime" class="easyui-textbox" style="width: 150px"> 发放状态: <input id="state" class="easyui-textbox" style="width: 150px"> <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'发放薪资列表', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>