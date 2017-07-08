<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
${msg}
<script type="text/javascript">
	parent.$.messager.alert('提示', '请重新登录', 'info',function(){
		parent.window.location.href = '${pageContext.request.contextPath}/page/login.do';
	});
</script>