<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="inc.jsp"></jsp:include>
<title>登录</title>
<script type="text/javascript">
	var imgCode;
	$(function() {
		loadCodeImg();
		$('#codeImage').load(function() {
			setTimeout('loadImgCode()', 1000);
		});
	});

	function loadImgCode() {
		$.post("${pageContext.request.contextPath}/img/loadImgCode.do", function(code) {
			imgCode = code;
		});
	}

	function loadCodeImg() {
		$('#imgCode').textbox("setText", "");
		$('#codeImage').attr('src', '${pageContext.request.contextPath}/img/imgCode.do?random=' + Math.random());
	}

	function login() {
		$('#loginForm').form('submit', {
			url : '${pageContext.request.contextPath}/page/login.do',
			success : function(d) {
				var json = $.parseJSON(d);
				if (json.success) {
					window.location.href = '${pageContext.request.contextPath}/page/index.do';
				} else {
					$.messager.show({
						title : '提示',
						msg : json.msg
					});
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="easyui-window" data-options="title:'登录',modal:true,collapsible:false,minimizable:false,maximizable:false,closable:false,draggable:false,resizable:false,iconCls:'icon-lock'" style="width: 350px; padding: 20px 50px 20px 50px;">
		<form id="loginForm" method="post">
			<div style="margin-bottom: 5px">
				<input id="cid" type="text" name="cid" data-options="iconCls:'icon-man',prompt:'账号',required:true" class="easyui-textbox" style="width: 100%; height: 30px; padding: 12px">
			</div>
			<div style="margin-bottom: 5px">
				<input id="cpwd" type="password" name="cpwd" data-options="iconCls:'icon-lock',prompt:'密码',required:true" class="easyui-textbox" style="width: 100%; height: 30px; padding: 12px">
			</div>
			<div style="margin-bottom: 5px">
				<input id="imgCode" class="easyui-textbox" type="text" style="width: 45%; height: 30px; padding: 12px" data-options="prompt:'验证码',required:true,validType:'equalsImgCode[imgCode]',missingMessage:''" /> <img id="codeImage" style="margin: 0 0 0 3px; vertical-align: middle; height: 26px;" src=""> <a onclick="loadCodeImg()" class="easyui-linkbutton" data-options="plain: true, iconCls:'icon-reload'">换一张</a>
			</div>
			<a class="easyui-linkbutton" style="padding: 5px 0px; width: 100%;" onclick="login()"> <span style="font-size: 14px;">登录</span>
			</a>
		</form>
	</div>
</body>
</html>