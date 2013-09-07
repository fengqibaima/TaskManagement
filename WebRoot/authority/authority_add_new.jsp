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
       <!--     <s:text name="addNewAuthority"/><br>
    <s:form action="addNewAuthorityAction" method="post">
    <table>
    	<tr><th><s:text name="name"/></th><td><s:textfield name="name" key="name"/><input type="text" name="name" id="name"></td></tr>
    	<tr><th><s:text name="url"/></th><td><input type="text" name="url" id="url"></td></tr>
    	<tr><th><s:text name="description"/></th><td><input type="text" name="description" id="description"></td></tr>
    	<tr><td><input type="submit" value="add new authority"></td></tr>
    </table>
    </s:form> -->
    <s:text name="addNewAuthority"/><br>
    <s:form namespace="/" action="addNewAuthorityAction" method="post">
    <table>
    	<tr><s:textfield name="name" key="name"/></tr>
    	<tr><s:textfield name="url" key="url" id="name"></s:textfield></tr>
    	<tr><s:textfield name="description" key="description"/></tr>
    	<tr><td colspan="2"><s:submit key="submit" theme="simple"/></td></tr>
    </table>
    </s:form>
    </center>
  </body>
</html>
