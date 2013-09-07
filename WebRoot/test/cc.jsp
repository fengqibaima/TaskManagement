<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
 function temp(id) {
 document.getElementById("temp").src = id;
 

  
 }
  function temps(id) {
  alert(id);
 }
</script>
</head>
<body>
 主页
<a href="test/bb.jsp" id="bb.jsp" onclick="temp(this.id);" > bb</a>
<a href="test/xx.jsp" id="xx.jsp" onclick="temp(this.id);" > cc</a>
<Iframe id="temp" src="test/xx.jsp" width="500" height="600">aa</IFRAME>
</body>
</html>
