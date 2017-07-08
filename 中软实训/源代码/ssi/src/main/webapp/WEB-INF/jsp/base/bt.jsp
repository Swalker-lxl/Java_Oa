<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/base/bt/datagrid.do',
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
				title : '姓名',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'btid',
				title : '出差编号',
				width : 100,
			}, {
				field : 'btsdate',
				title : '出差起时',
				width : 150
			}, {
				field : 'btedate',
				title : '出差止时',
				width : 150
			}, {
				field : 'btplace',
				title : '出差地点',
				width : 150
			}, {
				field : 'btvehicle',
				title : '交通工具',
				width : 150
			}, {
				field : 'btexplain',
				title : '说明',
				width : 150
			}, {
				field : 'btapprover',
				title : '审批人',
				width : 150
			}, {
				field : 'attappss',
				title : '审批状态',
				width : 150
			}, {
				field : 'btappdate',
				title : '审批时间',
				width : 150
			}, {
				field : 'addname',
				title : '新增人员',
				width : 150
			} , {
				field : 'addtime',
				title : '新增时间',
				width : 150
			} , {
				field : 'updatename',
				title : '修改人员',
				width : 150
			} , {
				field : 'updatetime',
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
			height : 250,
			closed : false,
			cache : false,
			href : '${pageContext.request.contextPath}/base/bt/btAdd.do',
			modal : true,
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = p.find("form");
					f.form('submit', {
						url : '${pageContext.request.contextPath}/base/bt/add.do',
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
				height : 250,
				closed : false,
				cache : false,
				href : '${pageContext.request.contextPath}/base/bt/btEdit.do',
				modal : true,
				buttons : [ {
					text : '修改',
					handler : function() {
						var f = p.find("form");
						f.form('submit', {
							url : '${pageContext.request.contextPath}/base/bt/edit.do',
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
						btid : rows[0].btid,
						btexplain : rows[0].btexplain,
						btplace : rows[0].btplace,
						btvehicle : rows[0].btvehicle,
						btapprover : rows[0].btapprover,
						attappss : rows[0].attappss,
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
			name : $("#name").val(),
			btsdate : $("#btsdate").val()
		});

	}

	function remove() {
		var rows = datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length != 0) {
			$.messager.confirm('确认对话框', '您想要删除记录吗？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].btid);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/base/bt/remove.do',
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
				<td>工号:<input id="id" class="easyui-textbox" style="width: 150px"> 姓名: <input id="name" class="easyui-textbox" style="width: 150px"> 出差起时:<input id="btsdate" class="easyui-datebox" style="width: 150px" data-options="editable:false"><a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'用户列表', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>