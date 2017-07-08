<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/salary/fiveandone/datagrid.do',
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
				title : '编号',
				width : 150,
				sortable : true
			}, {
				field : 'fname',
				title : '名称',
				width : 150,
			} ] ],
			columns : [ [  {
				field : 'scale',
				title : '比例',
				width : 150,
				sortable : true
			}]],
			toolbar : [ {
				iconCls : 'icon-add',
				text : '新增',
				handler : function() {
					add();
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '修改',
				handler : function() {
					edit();
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '删除',
				handler : function() {
					remove();
				}
			} ]

		});
	});

	function add() {
		var p = parent.js.dialog({
			title : '新增',
			width : 400,
			height : 150,
			closed : false,
			cache : false,
			href : '${pageContext.request.contextPath}/salary/fiveandone/fiveandoneAdd.do',
			modal : true,
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = p.find("form");
					f.form('submit', {
						url : '${pageContext.request.contextPath}/salary/fiveandone/add.do',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								p.dialog("close");
								query();
							}
							parent.$.messager.show({
								title : '提示',
								msg : json.msg
							});
						}
					});
				}
			} ]
		});
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
				href : '${pageContext.request.contextPath}/salary/fiveandone/fiveandoneEdit.do',
				modal : true,
				buttons : [ {
					text : '修改',
					handler : function() {
						var f = p.find("form");
						f.form('submit', {
							url : '${pageContext.request.contextPath}/salary/fiveandone/edit.do',
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
						id : rows[0].id,
						fname : rows[0].fname,
						scale : rows[0].scale
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
			id : $("#id").val(),
			fname : $("#fname").val()
		});

	}

	function remove() {
		var rows = datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length != 0) {
			$.messager.confirm('确认对话框', '您想要删除记录吗？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/salary/fiveandone/remove.do',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(d) {
							datagrid.datagrid('load');
							datagrid.datagrid('unselectAll');
							parent.$.messager.show({
								title : '提示',
								msg : d.msg
							});
						}
					});
				}
			});
		} else {
			parent.$.messager.alert('提示', '请选择要删除的记录！', 'error');
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'过滤条件',split:true, iconCls:'icon-search'" style="height: 65px;">
		<table>
			<tr>
				<td>编号:<input id="id" class="easyui-textbox" style="width: 150px"> 名称: <input id="fname" class="easyui-textbox" style="width: 150px"> <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'五险一金列表', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>