<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <frameset rows="82,*" cols="*" frameborder="yes" border="1" framespacing="0">
   <frame src="common/Title.jsp" name="topFrame" scrolling="NO" noresize >
   <frameset cols="180,*" frameborder="yes" border="1" framespacing="2" name="fraMenuReport" >
     <frame src="common/tree.jsp?menuStyle=simple" name="leftFrame" scrolling="no" >
     <frame src="common/main.jsp" name="mainFrame" scrolling="yes" >
   </frameset>
 </frameset>
 <noframes>
 <body>
 </body>
 </noframes>
 </html>
