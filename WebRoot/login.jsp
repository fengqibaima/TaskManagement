<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="stylr/styles.css">
	
  </head>
  
  <body>
    <h3><s:text name="userLogin"/></h3>
    <!-- <form action="loginLoginAction.action" method="post">
    	<table>
    		<tr align="center"><td><s:text name="username"/><input id="username" name="username" type="text"></td></tr>
    		<tr align="center"><td><s:text name="password"/><input id="password" name="password" type="password"></td></tr>
    		<tr align="center"><td colspan="2"><input type="submit" value="submit"><input type="reset" value="reset"></td></tr>
    	</table>
    </form> -->
    <!-- <s:form>
    	<table>
    		<tr align="center"><td><s:text name="username"/><s:textfield name="username" key="username"></s:textfield></td></tr>
    		<tr align="center"><td><s:text name="password"/><input id="password" name="password" type="password"></td></tr>
    		<tr align="center"><td colspan="2"><input type="submit" value="submit"><input type="reset" value="reset"></td></tr>
    	</table>   
    </s:form> -->   
    <s:form  namespace="/" action="loginUserAction" method="post">
    	<table>
    		<tr align="center"><td><s:textfield name="username" key="username"></s:textfield></td></tr>
    		<tr align="center"><td><s:password  name="password" key="password"></s:password></td></tr>
    		<tr align="center"><td colspan="2"><s:submit key="Login" theme="simple"/><s:reset key="reset" theme="simple"/></td></tr>
    	</table>   
    </s:form>
  </body>
</html>
