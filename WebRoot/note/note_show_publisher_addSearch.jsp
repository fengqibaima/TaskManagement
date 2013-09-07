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
    
    <title>My JSP 'note_show_publiser_addSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
       <script language="javascript" type="text/javascript" src="ssh/My97DatePicker/WdatePicker.js"></script>  
    <div>
    <s:text name="searchOption"/>
    <s:form action="showselectedPublishedNoteAction" method="post" target="a">
    <table>
   		<tr><th><s:text name="state"/></th><td><s:select name="stateid" id="stateid" list="stateList" listKey="id" listValue="name" theme="simple"/></td>
   			<th><s:text name="priority"/></th><td><s:select name="priorityid" id="priorityid" list="priorityList" listKey="id" listValue="chname" theme="simple"/></td>
   		</tr>
    	<tr><th><s:text name="category"/></th><td><s:select name="categoryid" id="categoryid" list="categoryList" listKey="id" listValue="chname" theme="simple"/></td>
    		<th><s:text name="recordTime"/></th><td><s:textfield  id="startTime" name="startTime" key="startTime" onclick="WdatePicker()" theme="simple"/></td>
    	</tr>
    	<tr><th><s:text name="startTime"/></th><td><s:textfield  id="startTime" name="startTime" key="startTime" onclick="WdatePicker()" theme="simple"/></td>
    		<th><s:text name="endTiem"/></th><td><s:textfield  id="startTime" name="startTime" key="startTime" onclick="WdatePicker()" theme="simple"/></td>
   		</tr>
   		<tr><td><s:submit key="submit" theme="simple"></s:submit></td></tr>
    </table>
    </s:form>
    
	</div>
	<div>
	<Iframe width="90%" height="100%" scrolling="no" frameborder="0" name="a" id="a"></iframe>
	</div>
  </body>
</html>
