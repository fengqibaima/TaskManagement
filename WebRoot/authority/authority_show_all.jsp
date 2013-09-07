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
    
    <title>My JSP 'authority_show_all.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
      	<center>
    	<s:text name="authorityList"></s:text> <br>
        	<table>
    			<tr><th><s:text name="name"/></th><th><s:text name="url"/></th><th><s:text name="view"/></th><th><s:text name="delete"/></th></tr>
    			<s:iterator id="authoritys" value="authorityList">
    				<tr><td><s:property value="name"/></td>
    				<td><s:property value="url"/></td>
    			    <td><a href="<%=path%>/showDetailAuthorityAction.action?authorityId=<s:property value="id"/>"><s:text name="view"/></a></td>
    			   	<td><a href="<%=path%>/deleteOneAuthorityAction.action?authorityId=<s:property value="id"/>"><s:text name="delete"/></a></td>
    			    </tr>
    			</s:iterator>
    			<tr><td><s:url id="url1" action="showAddNewPageAuthorityAction.action"></s:url><s:a href="%{url1}"><s:text name="addNew"/></s:a>
    		</table>    	
    </center>
  </body>
</html>
