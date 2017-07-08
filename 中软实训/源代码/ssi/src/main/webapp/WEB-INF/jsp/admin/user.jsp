<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/admin/user/datagrid.do',
			fit : true,
			striped : true,
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 20,
			pageList : [ 20, 40, 60, 80, 100 ],
			idField : 'cid',
			sortName : 'cid',
			sortOrder : 'asc',
			frozenColumns : [ [ {
				checkbox : true,
				title : '',
				field : ''
			},{
				field : 'cid',
				title : '账号',
				width : 100,
				sortable : true
			},  {
				field : 'cname',
				title : '昵称',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'cpwd',
				title : '密码',
				width : 100,
				formatter : function(value, rowData, rowIndex) {
					return '******';
				}
			}, {
				field : 'createid',
				title : '新增人员',
				width : 150
			}, {
				field : 'createtime',
				title : '新增时间',
				width : 150
			}, {
				field : 'modifyid',
				title : '修改人员',
				width : 150
			}, {
				field : 'modifytime',
				title : '修改时间',
				width : 150
			} ] ],
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
			href : '${pageContext.request.contextPath}/admin/user/userAdd.do',
			modal : true,
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = p.find("form");
					f.form('submit', {
						url : '${pageContext.request.contextPath}/admin/user/add.do',
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
						cid : rows[0].cid,
						cname : rows[0].cname
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
			cid : $("#cid").val(),
			cname : $("#cname").val()
		});

	}

	function remove() {
		var rows = datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length != 0) {
			$.messager.confirm('确认对话框', '您想要删除记录吗？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].cid);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/admin/user/remove.do',
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
	<div data-options="region:'north',title:'检索条件',split:true, iconCls:'icon-search'" style="height: 65px;">
		<table>
			<tr>
				<td>账号:<input id="cid" class="easyui-textbox" style="width: 150px"> 昵称: <input id="cname" class="easyui-textbox" style="width: 150px"> <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'用户列表', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>