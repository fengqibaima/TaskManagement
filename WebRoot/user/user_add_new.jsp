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
    
    <title>My JSP 'authority_add_new.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
       <center>
    <s:text name="addNewUser"/><br>
    <s:form namespace="/" action="addNewUserAction" method="post">
    <table>
    	<tr><s:textfield name="username" key="username"/></tr>
    	<tr><s:textfield name="realname" key="realname"/></tr>
    	<tr><s:textfield name="email" key="email"/></tr>
    	<tr><th colspan="1"><s:text name="department"/></th><td colspan="1"><s:select list="departmentList" listKey="id" listValue="name" name="departmentId"  theme="simple"></s:select></td></tr>
    	<tr><th colspan="1"><s:text name="authority"/></th><td colspan="1"><s:checkboxlist name="selectedAuthoritys" list="authorityList" theme="simple" listKey="id" listValue="name"/></td></tr>
    	<tr><td colspan="2"><s:submit name="addNew" theme="simple" key="addNew"/></td></tr>
    </table>
    </s:form>
    </center>
  </body>
</html>
