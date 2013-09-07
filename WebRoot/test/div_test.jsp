<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'div_test.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<style type="text/css">
#left {
	float: left;
	height: 100%;
	width: 50%;
	border-right: solid #990 1px;
	background: #999;
}

#right {
	float: right;
	height: 100%;
	background: #CCC;
	width: 50%;
}
</style>
	</head>

	<body>
		<div id="left">
			<Iframe src="/base/menu.jsp";width="100%" height="100%"scrolling="no"frameborder="0"></iframe> 
		</div>
		<div id="right"></div>
	</body>
</html>
