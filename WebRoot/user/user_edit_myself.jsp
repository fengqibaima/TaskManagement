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
    
    <title>My JSP 'user_edit_myself.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
    <s:text name="editMyself"/><br>
    <s:form namespace="/" action="editMyselfUserAction" method="post">
    <table>
    	<tr><th><s:text name="username"/></th><td><s:property value="username"/></td></tr>
    	<tr><th><s:text name="realname"/></th><td><s:property value="realname"/></td></tr>
    	<tr><s:textfield name="password" key="password" value="%{#session.user.password}"/></tr>
    	<tr><s:textfield name="email" key="emial" value="%{#session.user.email}"/></tr>
    	<tr><th><s:text name="registeredTime"/></th><td><s:property value="registedTime"/></td></tr>
    	<tr><th><s:text name="department"/></th><td><s:property value="departmentName"/></td></tr>
    	<tr><th><s:text name="authority"/>(temporary useless)</th><td><s:property value="authority"/></td></tr>
    	<tr><th><s:text name="haveAuthority"/></th>   	
    		<td><table><s:iterator value="authorityList"><tr><td><s:property value="name"/>&nbsp;&nbsp;&nbsp;</td></tr></s:iterator></table></td>    	
    	</tr>
	   	<tr><td colspan="2"><s:submit name="editMyself" key="upload" theme="simple"/></td></tr> 	
    </table>
    </s:form>
  </body>
</html>
