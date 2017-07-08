<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/performance/kpi/datagrid.do',
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
			}, 
			{
				field : 'id',
				title : 'ID',
				width : 100
			},
			{
				field : 'percontent',
				title : 'KPI考核点',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'pername',
				title : '考核内容',
				width : 100			
			}, {
				field : 'post',
				title : '岗位',
				width : 150
			}, {
				field : 'flag',
				title : '是否启用',
				width : 150,
				formatter : function(value, rowData, rowIndex) {
					if(value=="0"){
						return "未启用";
					}
					else
						return "已启用";
				}
			}, {
				field : 'modifyname',
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
			width : 500,
			height : 180,
			closed : false,
			cache : false,
			href : '${pageContext.request.contextPath}/performance/kpi/kpiAdd.do',
			modal : true,
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = p.find("form");
					f.form('submit', {
						url : '${pageContext.request.contextPath}/performance/kpi/add.do',
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
				width : 500,
				height : 200,
				closed : false,
				cache : false,
				href : '${pageContext.request.contextPath}/performance/kpi/kpiEdit.do',
				modal : true,
				buttons : [ {
					text : '修改',
					handler : function() {
						
						var f = p.find("form");
						f.form('submit', {
							url : '${pageContext.request.contextPath}/performance/kpi/edit.do',
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
						percontent : rows[0].percontent,
						pername : rows[0].pername,
						flag : rows[0].flag,
						post : rows[0].post,
						modifyname : rows[0].modifyname
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
			percontent : $("#percontent").val(),
			post : $("#post").val()
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
						url : '${pageContext.request.contextPath}/performance/kpi/remove.do',
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
				<td>KPI考核点:<input id="percontent" class="easyui-textbox" style="width: 150px"> 岗位: <input id="post" class="easyui-textbox" style="width: 150px"> <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',title:'KPI绩效', iconCls:'icon-save'" style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>