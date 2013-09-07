<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.ascent.domain.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'note_add_new.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">
	
  </head>
  
  <body>
  
        <script language="javascript" type="text/javascript" src="ssh/My97DatePicker/WdatePicker.js"></script>
        <center>
        
        <s:text name="addNewAssignment"/><br>
        <s:form namespace="/" action="addNewNoteAction" method="post">        
    	<table>
    		<tr><th colspan="1"><s:text name="title"/></th><td colspan="3"><s:textfield name="title" key="title" theme="simple"/></td></tr>
    		<tr><th colspan="1"><s:text name="content"/></th><td colspan="3"><s:textfield name="content" key="content" theme="simple"/></td></tr>
    		<tr><th colspan="1"><s:text name="startTime"/></th><td colspan="1"><s:textfield  id="startTime" name="startTime" key="startTime" onclick="WdatePicker()" theme="simple"/></td>
    			<th colspan="1"><s:text name="endTime"/></th><td colspan="1"><s:textfield name="endTime" key="endTime" onclick="WdatePicker()" theme="simple"/></td>
    		</tr>
    		<tr><th colspan="1"><s:text name="state"/></th>    				
    			<td colspan="1">
    				 <s:select name="stateid" list="stateList" listKey="id" listValue="name" theme="simple"></s:select> 
    			</td>
    			<th colspan="1"><s:text name="category"/></th>    				
    			<td colspan="1">
    				 <s:select name="categoryid" list="categoryList" listKey="id" listValue="chname" theme="simple"></s:select> 
    			</td>
    		</tr>
    		<tr>
    			<th colspan="1"><s:text name="priority"/></th>    				
    			<td colspan="1">
    				 <s:select name="priorityid" list="priorityList" listKey="id" listValue="chname" theme="simple"></s:select> 
    			</td>
    			<th colspan="1"><s:text name="publisher"/></th><td><s:property value="user.realname"/></td>
    		</tr>
    		<tr><th colspan="1"><s:text name="executor"/></th>
    			<td><s:select list="userList" listKey="id" listValue="realname" name="executorId" theme="simple"></s:select></td>
    			<td colspan="2"></td>
    		</tr>
			<tr><th colspan="1">
				<s:text name="nextStep"/></th>
				<td><s:select list="#{'planedByExecutor':'执行者自拟计划','planedByPubliser':'发布者给出计划'}" name="nextStep" theme="simple"></s:select></td>
				<td colspan="2"></td>
			</tr>
    		<tr><td colspan="4"><s:submit name="submit" key="submit" theme="simple"/></td></tr>
    	</table>
    	</s:form> 
    	
        
        <!--         <s:form action="addNewNoteAction" method="post">        
    	<table>
    		<tr><td colspan="4"><s:textfield name="title" key="title" theme="simple"/></td></tr>
    		<tr><td colspan="4"><s:textfield name="content" key="content" theme="simple"/></td></tr>
    		<tr><td colspan="4"><s:textfield name="title" key="title" theme="simple" onclick="WdatePicker()"/></td></tr>
    		<tr><th colspan="1">start time: </th><td><input id="startTime" type="text" name="startTime" class="Wdate" onclick="WdatePicker()"></td>
    			<th colspan="1">end time: </th><td colspan="1"><input type="text" class="Wdate" name="endTime" id="endTime" onclick="WdatePicker()"></td>
    		</tr>
    		<tr><th>state: </th>    				
    			<td>
    					<select name="state">
    						<option value="processing" selected="selected">processing</option>
    						<option value="suspend">suspend</option>
    						<option value="end">end</option>
    					</select>
    			</td>
    			<th>category: </th>
				<td>
    					<select name="category">
    						<option value="development" selected="selected">development</option>
    						<option value="test">test</option>
    						<option value="requirement">requirement</option>
    					</select>
    			</td>
    		</tr>
    		<tr><th>priority: </th>
				<td>
    					<select name="priority">
    						<option value="high">high</option>
    						<option value="medium" selected="selected">medium</option>
    						<option value="low">low</option>
    					</select>
    			</td>
    			<th>publisher: </th><td><s:property value="user.username"/></td>
    		</tr>
    		<tr><th>executor: </th><td><s:select list="userList" listKey="id" listValue="username" name="executorId" theme="simple"></s:select></td><td colspan="2"></td>
			</tr>
    		<tr><td colspan="4"><input type="submit" name="submit"></td></tr>
    	</table>
    	</s:form> -->
    </center>
  </body>
</html>
