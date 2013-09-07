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
    <s:text name="viewUser"/><br>
    <table>
    	<tr><th><s:text name="username"/></th><td><s:property value="username"/></td></tr>
    	<tr><th><s:text name="realname"/></th><td><s:property value="realname"/></td></tr>
    	<tr><th><s:text name="email"/></th><td><s:property value="email"/></td></tr>
    	<tr><th><s:text name="registeredTime"/></th><td><s:property value="registedTime"/></td></tr>
    	<tr><th><s:text name="department"/></th><td><s:property value="departmentName"/></td></tr>
    	<tr><th><s:text name="authority"/>(temporary useless)</th><td><s:property value="authority"/></td></tr>
    	<tr><th><s:text name="haveAuthority"/></th>   	
    		<td><table><s:iterator value="authorityList"><tr><td><s:property value="name"/>&nbsp;&nbsp;&nbsp;</td></tr></s:iterator></table></td>    	
    	</tr>
    </table>
    </center>
  </body>
</html>
