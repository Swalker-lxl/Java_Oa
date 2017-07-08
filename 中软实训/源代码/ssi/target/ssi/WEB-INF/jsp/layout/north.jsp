<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function logout() {
		$('#userInfoDiv').html('');
		$.post('${pageContext.request.contextPath}/page/logout.do', function() {
			window.location.href = '${pageContext.request.contextPath}/page/login.do';
		});
	}

	function showUserInfo() {
		var p = parent.$("<div/>").dialog({
			title : '用户',
			href : '${pageContext.request.contextPath}/admin/user/userInfo.do',
			width : 300,
			height : 260,
			modal : true,
			buttons : [ {
				text : '修改密码',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '${pageContext.request.contextPath}/admin/user/editUserInfo.do',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								p.dialog('close');
							}
							parent.$.messager.show({
								msg : json.msg,
								title : '提示'
							});
						}
					});
				}
			} ]
		});
	}
</script>
<div id="userInfoDiv" style="position: absolute; top: 10px;">
	<c:if test="${userInfo.userId != null}">[<strong>${userInfo.userName}</strong>]，欢迎你！您使用[<strong>${userInfo.ip}</strong>]IP登录！</c:if>
</div>
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0)" id="north_menu" class="easyui-menubutton" data-options="menu:'#layout_setting',iconCls:'icon-setting'">设置</a>
</div>
<div id="layout_setting" style="width: 100px;">
	<div data-options="iconCls:'icon-man'" onclick="showUserInfo()">用户</div>
	<div data-options="iconCls:'icon-lock'" onclick="logout()">退出</div>
</div>