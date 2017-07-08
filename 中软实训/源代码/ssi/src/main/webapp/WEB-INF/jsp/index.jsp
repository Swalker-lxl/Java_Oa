<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SSM</title>
<jsp:include page="inc.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',href:'${pageContext.request.contextPath}/layout/north.do'" style="height: 30px; overflow: hidden;"></div>
	<div data-options="region:'west',title:'功能导航',href:'${pageContext.request.contextPath}/layout/west.do'" style="width: 200px; overflow: hidden;"></div>
	<div data-options="region:'center',title:'欢迎使用',href:'${pageContext.request.contextPath}/layout/center.do'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'${pageContext.request.contextPath}/layout/south.do'" style="height: 20px; overflow: hidden;"></div>
</body>
</html>