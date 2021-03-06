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
    
    <title>My JSP 'note_show_executor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
     	<center>
     	<div>
     		
     	</div>
     	<div>
    	<s:text name="myAssignmentList"/><br>
        <table>
    		<tr><th><s:text name="title"/></th><th><s:text name="recordTime"/></th><th><s:text name="state"/></th><th><s:text name="publisher"/></th><th><s:text name="executor"/><th><s:text name="startTime"/></th><th><s:text name="endTime"/></th><th><s:text name="edit"/></th></tr>
    		<s:iterator id="notes" value="#request['noteList']">
    			<tr><td><s:property value="title"/></td>
    			<td><s:property value="date"/></td>
    			<td><s:property value="state.name"/></td>
    			<td><s:iterator value="NotePublishers"><s:property value="realname"></s:property>&nbsp;&nbsp;</s:iterator></td>
    		    <td><s:iterator value="NoteExecutors"><s:property value="realname"></s:property>&nbsp;&nbsp;</s:iterator></td>
    			<td><s:property value="starttime"/></td>
    		    <td><s:property value="endtime"/></td>
    		    <!-- <td><a href="<%=path%>/showNoteDetailNoteAction.action?noteId=<s:property value="id"/>"><s:text name="view"/></a></td> -->
    		    <td><a href="<%=path%>/showEditPageExecutorPlanAction.action?noteId=<s:property value="id"/>"><s:text name="edit"/></a></td>			    
    		    </tr>
    		</s:iterator>
    	</table>
    	</div>    	
    </center>
  </body>
</html>