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
    
    <title>My JSP 'user_edit_one.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
    <center>
    <s:text name="editUser"/><br>
    <s:form namespace="/" action="editOneUserAction" method="post">
    <table>
    	<tr><s:textfield name="username" key="username" value="%{#session.tempUser.username}"/></tr>
    	<tr><s:textfield name="realname" key="realname" value="%{#session.tempUser.realname}"/></tr>
    	<tr><s:textfield name="email" key="emial" value="%{#session.tempUser.email}"/></tr>  
    	<tr><th><s:text name="department"/></th>
    		<td><s:select list="departmentList" listKey="id" listValue="name" name="departmentId" value="selectedDepartment"  theme="simple"></s:select></td>
    	</tr>
    	<tr><th><s:text name="haveAuthority"/></th>
    		<td><s:checkboxlist name="selectedAuthoritys" list="authorityList" theme="simple" listKey="id" listValue="name" value="ownAuthorityList"/></td>
    	</tr>
	   	<tr><td colspan="2"><s:submit name="editUser" key="upload" theme="simple"/></td></tr> 	
    </table>
    </s:form>
    
    <!--     <s:text name="editUser"/><br>
    <form action="editOneUserAction.action" method="post">
    <table>
    	<tr><th>user name: </th><td><input type="text" name="username" id="username" value="<s:property value="user.username"/>"></td></tr>
    	<tr><th>password: </th><td><input type="text" name="password" id="password" value="<s:property value="user.password"/>"></td></tr>
    	<tr><th>email: </th><td><input type="text" name="email" id="email" value="<s:property value="user.email"/>"></td></tr>
    	<tr><th>department: </th><td><s:select list="departmentList" listKey="id" listValue="name" name="departmentId" value="selectedDepartment"  theme="simple"></s:select></td></tr>
	   	<tr><th>authority: </th><td><s:checkboxlist name="selectedAuthoritys" list="authorityList" theme="simple" listKey="id" listValue="name" value="ownAuthorityList"/></td></tr>   
	   	<tr><td colspan="2"><input type="submit" value="edit user"></td></tr> 	
    </table>
    </form>
     -->
    </center>
  </body>
</html>
