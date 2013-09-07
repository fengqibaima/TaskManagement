<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.ascent.domain.Authority" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome_page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
      <%
    	List<Authority> authorityList= (List<Authority>) session.getAttribute("authorityList");
     %>
     <div id="left_div">
    	<center>
    	<s:text name="welcome"/><s:property value="realname"></s:property>
    	<table>
    		<s:iterator value="authorityList">
    		<tr><td><a href="<s:property value="url"/>" target="_x"><s:property value="name"></s:property></a></td>
    		</tr>
    		</s:iterator>
    		<tr><td><s:url action="logOutUserAction.action" id="url_logout"></s:url>
    				<s:a href="%{url_logout}"><s:text name="logout"/></s:a>
    	</table>
    	</center>
    </div>
    <div id="right_div">
    	 <Iframe width="90%" height="100%" scrolling="yes" frameborder="0" name="_x" id="_x"></iframe>
	</div>    
  </body>
</html>
