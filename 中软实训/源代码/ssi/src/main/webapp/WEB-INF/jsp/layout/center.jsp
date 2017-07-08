<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var centerTabs;
	var datagrid;
	$(function() {
		centerTabs = $('#centerTabs').tabs({
			border : false,
			fit : true
		});
		
		datagrid = $('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/message/mes/datagrid.do',
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
			},{
				field : 'flac',
				title : '是否已读',
				width : 100,
				sortable : true,
				formatter : function(value, rowData, rowIndex) {
					return value=='0'?"未读":"已读";
				}
			},  {
				field : 'sendid',
				title : '发件人',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [  {
				field : 'theme',
				title : '主题',
				width : 150
			}, {
				field : 'content',
				title : '内容',
				width : 400
			}, {
				field : 'sentime',
				title : 'time',
				width : 150
			} ] ],
			toolbar : [ {
				iconCls : 'icon-add',
				text : '写消息',
				handler : function() {
					add();
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '标记已读',
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
			title : '草稿',
			width : 400,
			height : 500,
			closed : false,
			cache : false,
			href : '${pageContext.request.contextPath}/message/mes/mesAdd.do',
			modal : true,
			buttons : [ {
				text : '发送',
				handler : function() {
					var f = p.find("form");
					f.form('submit', {
						url : '${pageContext.request.contextPath}/message/mes/add.do',
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
	function query() {
	
		var v = $('#sentime').datebox('getValue');
	
         
		datagrid.datagrid('load', {
			sentime : v,
			
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
						url : '${pageContext.request.contextPath}/message/mes/remove.do',
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
	function edit() {
		var rows = datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length != 0) {
			$.messager.confirm('确认对话框', '您想要标记记录吗？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/message/mes/edit.do',
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
		} 
	}
</script>
<div id="centerTabs">
	<div title="首页" data-options="border:false,href:''" style="overflow: hidden;">
	<div data-options="region:'north',title:'检索条件',split:true, iconCls:'icon-search'" style="height: 50px;">
		<table>
			<tr>
				<td>发送时间:<input id="sentime" name="sentime" type="text" class="easyui-datebox" required="required"></input><a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="datagrid"></table>
	</div>
</div>