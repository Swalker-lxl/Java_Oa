<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script>
	var datagrid;
	$(function() {
		datagrid = $('#datagrid')
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/performance/perss/datagrid.do',
							fit : true,
							striped : true,
							pagination : true,
							pagePosition : 'bottom',
							pageSize : 20,
							pageList : [ 20, 40, 60, 80, 100 ],
							idField : 'id',
							sortName : 'monthtime',
							sortOrder : 'asc',
							frozenColumns : [ [ {
								checkbox : true,
								title : '',
								field : ''
							}, {
								field : 'id',
								title : 'ID',
								width : 100
							}, {
								field : 'monthtime',
								title : '绩效时间',
								width : 100,
								sortable : true
							} ] ],
							columns : [ [ {
								field : 'state',
								title : '启用状态',
								width : 100,
								formatter : function(value, rowData, rowIndex) {
									if (value == "0") {
										return "未启用";
									} else
										return "已启用";
								}
							}, {
								field : 'createdatetime',
								title : '新增时间',
								width : 150
							}, {
								field : 'createname',
								title : '新增人员',
								width : 150
							}, {
								field : 'modifyname',
								title : '修改人员',
								width : 150
							}, {
								field : 'modifydatetime',
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
		var p = parent.js
				.dialog({
					title : '新增',
					width : 550,
					height : 200,
					closed : false,
					cache : false,
					href : '${pageContext.request.contextPath}/performance/perss/perssAdd.do',
					modal : true,
					buttons : [ {
						text : '保存',
						handler : function() {
							var f = p.find("form");
							f
									.form(
											'submit',
											{
												url : '${pageContext.request.contextPath}/performance/perss/add.do',
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
			var p = parent.js
					.dialog({
						title : '修改',
						width : 400,
						height : 150,
						closed : false,
						cache : false,
						href : '${pageContext.request.contextPath}/performance/perss/perssEdit.do',
						modal : true,
						buttons : [ {
							text : '修改',
							handler : function() {
								var f = p.find("form");
								f
										.form(
												'submit',
												{
													url : '${pageContext.request.contextPath}/performance/perss/edit.do',
													success : function(d) {
														var json = $
																.parseJSON(d);
														if (json.success) {
															p.dialog("close");
															query();
															datagrid
																	.datagrid('unselectAll');
														}
														parent.$.messager
																.show({
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
								monthtime : rows[0].monthtime,
								state : rows[0].state,
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
			$.messager
					.confirm(
							'确认对话框',
							'您想要删除记录吗？',
							function(r) {
								if (r) {
									for (var i = 0; i < rows.length; i++) {
										ids.push(rows[i].id);
									}
									$
											.ajax({
												url : '${pageContext.request.contextPath}/performance/perss/remove.do',
												data : {
													ids : ids.join(',')
												},
												dataType : 'json',
												success : function(d) {
													datagrid.datagrid('load');
													datagrid
															.datagrid('unselectAll');
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
	<div data-options="region:'center',title:'绩效起停', iconCls:'icon-save'"
		style="padding: 5px; background: #eee;">
		<table id="datagrid"></table>
	</div>
</body>
</html>