<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var treegrid;
	$(function() {

		treegrid = $('#treegrid').treegrid({
			url : '${pageContext.request.contextPath}/structure/dept/treegrid.do',
			toolbar : [ {
				text : '展开',
				iconCls : 'icon-redo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('expandAll', node.cid);
					} else {
						treegrid.treegrid('expandAll');
					}
				}
			}, '-', {
				text : '折叠',
				iconCls : 'icon-undo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('collapseAll', node.cid);
					} else {
						treegrid.treegrid('collapseAll');
					}
				}
			}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					treegrid.treegrid('reload');
				}
			}, '-', {
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
			}, '-' ],
			title : '',
			iconCls : 'icon-save',
			fit : true,
			fitColumns : true,
			nowrap : false,
			animate : false,
			border : false,
			idField : 'pid',
			treeField : 'pname',
			frozenColumns : [ [ {
				title : 'pid',
				field : 'pid',
				width : 150,
				hidden : true
			}, {
				field : 'pname',
				title : '部门名称',
				width : 180
			} ] ],
			columns : [ [ {
				field : 'pidconcls',
				title : '部门图标',
				width : 70,
				formatter : function(value) {
					if (!value) {
						return '';
					} else {
						return js.fs('<span class="{0}" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span>', value);
					}
				}
			}, {
				field : 'message',
				title : '部门简介',
				width : 250
			}, {
				field : 'cseq',
				title : '排序',
				width : 40
			}, {
				field : 'cpid',
				title : '上级菜单ID',
				width : 150,
				hidden : true
			} ] ],
			onContextMenu : function(e, row) {
				e.preventDefault();
				$(this).treegrid('unselectAll');
				$(this).treegrid('select', row.pid);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			onExpand : function(row) {
				treegrid.treegrid('unselectAll');
			},
			onCollapse : function(row) {
				treegrid.treegrid('unselectAll');
			}
		});

	});

	function add() {
		var p = parent.js.dialog({
			title : '新增部门',
			href : '${pageContext.request.contextPath}/structure/dept/deptAdd.do',
			width : 500,
			height : 220,
			buttons : [ {
				text : '新增',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '${pageContext.request.contextPath}/structure/dept/add.do',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								treegrid.treegrid('reload');
								p.dialog('close');
								parent.menuTree.tree('reload');/*刷新左侧菜单树*/
							}
							parent.$.messager.show({
								msg : json.msg,
								title : '提示'
							});
						}
					});
				}
			} ],
			onLoad : function() {
				var f = p.find('form');
				var cpid = f.find('input[name=cpid]');
				var iconCls = f.find('input[name=pidconcls]');
				var iconCombo = iconCls.combobox({
					data : js.iconData,
					formatter : function(v) {
						return js.fs('<span class="{0}" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span>{1}', v.value, v.value);
					}
				});
				var ptree = cpid.combotree({
					lines : true,
					url : '${pageContext.request.contextPath}/structure/dept/notNeedAuth_menuTree.do'
				});
			}
		});
	}

	function edit() {
		var node = treegrid.treegrid('getSelected');
		if (node) {
			var p = parent.js.dialog({
				title : '修改部门',
				href : '${pageContext.request.contextPath}/structure/dept/deptEdit.do',
				width : 500,
				height : 220,
				buttons : [ {
					text : '修改',
					handler : function() {
						var f = p.find('form');
						f.form('submit', {
							url : '${pageContext.request.contextPath}/structure/dept/edit.do',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									treegrid.treegrid('reload');
									p.dialog('close');
									parent.menuTree.tree('reload');/*刷新左侧菜单树*/
								}
								parent.$.messager.show({
									msg : json.msg,
									title : '提示'
								});
							}
						});
					}
				} ],
				onLoad : function() {
					var f = p.find('form');
					var cpid = f.find('input[name=cpid]');
					var iconCls = f.find('input[name=pidconcls]');
					var iconCombo = iconCls.combobox({
						data : js.iconData,
						formatter : function(v) {
							return js.fs('<span class="{0}" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span>{1}', v.value, v.value);
						}
					});
					var ptree = cpid.combotree({
						lines : true,
						url : '${pageContext.request.contextPath}/structure/dept/notNeedAuth_menuTree.do',
					});
					f.form('load', node);
				}
			});
		} else {
			parent.$.messager.alert('提示', '请选中要修改的记录！', 'error');
		}
	}

	function remove() {
		var node = treegrid.treegrid('getSelected');
		if (node) {
			parent.$.messager.confirm('询问', '您确定要删除<' + node.cname + '>？', function(b) {
				if (b) {
					$.ajax({
						url : '${pageContext.request.contextPath}/structure/dept/remove.do',
						data : {
							pid : node.pid
						},
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.success) {
								treegrid.treegrid('reload');
								treegrid.treegrid('unselectAll');
								parent.menuTree.tree('reload');/*刷新左侧菜单树*/
							}
							parent.$.messager.show({
								msg : r.msg,
								title : '提示'
							});
						}
					});
				}
			});
		}
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="treegrid"></table>
	</div>

	<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
		<div onclick="add();" data-options="iconCls:'icon-add'">新增</div>
		<div onclick="edit();" data-options="iconCls:'icon-edit'">修改</div>
		<div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
	</div>
</body>
</html>