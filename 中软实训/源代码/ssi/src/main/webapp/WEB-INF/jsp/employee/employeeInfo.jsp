<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/emp/employee/datagrid.do',
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
			}, {
				field : 'hiredate',
				title : '入职时间',
				width : 150
			}, {
				field : 'leavedate',
				title : '离职时间',
				width : 150
			}, {
				field : 'addname',
				title : '添加人员',
				width : 150
			}, {
				field : 'addtime',
				title : '添加时间',
				width : 150
			}, {
				field : 'updatename',
				title : '更新人员',
				width : 150
			}, {
				field : 'updatetime',
				title : '更新时间',
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
			height : 400,
			closed : false,
			cache : false,
			href : '${pageContext.request.contextPath}/emp/employee/empAdd.do',
			modal : true,
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = p.find("form");
					f.form('submit', {
						url : '${pageContext.request.contextPath}/emp/employee/add.do',
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
				height : 400,
				closed : false,
				cache : false,
				href : '${pageContext.request.contextPath}/emp/employee/userEdit.do',
				modal : true,
				buttons : [ {
					text : '修改',
					handler : function() {
						var f = p.find("form");
						f.form('submit', {
							url : '${pageContext.request.contextPath}/emp/employee/edit.do',
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
						name : rows[0].name,
						sex : rows[0].sex,
						photo : rows[0].photo,
						depart : rows[0].depart,
						position : rows[0].position,
						station : rows[0].station,
						location : rows[0].location,
						pnumber : rows[0].pnumber,
						email : rows[0].email,
						hiredate : rows[0].hiredate,
						leavedate : rows[0].leavedate,
						addname : rows[0].addname,
						addtime : rows[0].addtime,
						updatename : rows[0].updatename,
						updatetime : rows[0].updatetime
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
			name : $("#name").val()
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
						url : '${pageContext.request.contextPath}/emp/employee/remove.do',
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