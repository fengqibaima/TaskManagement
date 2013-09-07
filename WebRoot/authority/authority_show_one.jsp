<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'authority_show_one.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
    
    <center>
    <s:text name="viewAuthority"/><br>
    <table>
    	<tr><th><s:text name="name"/></th><td><s:property value="authority.name"/></td></tr>
    	<tr><th><s:text name="url"/></th><td><s:property value="authority.url"/></td></tr>
    	<tr><th><s:text name="description"/></th><td><s:property value="authority.description"/></td></tr>
    </table>
    </center>
  </body>
</html>
