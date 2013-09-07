<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.text.SimpleDateFormat"  %>
<%@ page import="java.util.Date" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    			Date now = new Date();
    			String nowStr = (new SimpleDateFormat("yyyy-MM-dd")).format(now);
    			request.setAttribute("curDate",nowStr);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'note_plan_edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
  		${curDate}
        <center>
    	<s:text name="fillInPlan"/><br>
    	<table>
    		<tr><th colspan="1"><s:text name="title"/></th><td colspan="7"  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.title"/></td></tr>
    		<tr><th colspan="1"><s:text name="content"/></th><td colspan="7"  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.content"/></td></tr>
    		<tr><th><s:text name="recordTime"/></th><td bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="recordTime"></s:property></td>
    			<th><s:text name="priority"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.priority.chname"/></td>
    			<th><s:text name="startTime"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="startTime"/>
    			<th><s:text name="endTime"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="endTime"/></td>
    		</tr>
    		<tr><th><s:text name="state"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.state.name"/>
    			<th><s:text name="category"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.category.chname"/></td>
    			<th><s:text name="publisher"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:iterator value="publishersList"><s:property value="realname"></s:property>&nbsp;&nbsp;</s:iterator></td>
    			<th><s:text name="executor"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:iterator value="executorsList"><s:property value="realname"></s:property>&nbsp;&nbsp;</s:iterator></td>
    		</tr>
    	</table>
    	<br>
    	<s:text name="checkListForPlan"/>
    	<br>

    	<s:form namespace="/" action="editExecutorPlanAction" method="post"> 
    	
    	    <table>
    		<tr><th><s:text name="date"></s:text></th>
    			<th><s:text name="planContent"/></th>
    			<th><s:text name="planComment"/></th>
    			<th><s:text name="planTime"/></th>
    			<th><s:text name="usedTime"/></th>
    		</tr>
    		<s:iterator value="planList" id="planList">
     		<% String state = (String) session.getAttribute("tempState"); 
     			if(state.equals("start")){
     		%>
    		<tr><td><s:property value="date" /></td>
    			<td><s:textfield name="content" id="content" theme="simple"/></td>
    			<td><s:property value="comment"/></td>
    			<td><s:textfield name="expectedtime" id="expectedtime" theme="simple"/></td>
    			<td><s:property value="usedtime"/></td>
    		</tr>
    		<%}else if(state.equals("process")){ %>
    		<tr><td><s:property value="date" id="tempDate"/></td>
    			<td><s:property value="content"/></td>
    			<td><s:textfield name="comment" id="comment" theme="simple"/></td>
    			<td><s:property value="expectedtime"/></td>
    			<td><s:textfield name="usedtime" id="usedtime" theme="simple"/></td>
    		</tr>
    		<%} else if(state.equals("end")){%>
    		<tr><td><s:property value="date" id="tempDate"/></td>
    			<td><s:property value="content"/></td>
    			<td><s:property value="comment"/></td>
    			<td><s:property value="expectedtime"/></td>
    			<td><s:property value="usedtime"/></td>
    		</tr>
    		<%} %>
    		</s:iterator>
 			</table>
 			
 			<br>
 			<br>
    		<table>
    			<tr><th colspan="8"><s:text name="newComment"/></th></tr>
    			<tr><th colspan="1"><s:text name="content"/></th>
    				<td colspan="6"><s:textfield name="commentContent" key="commentContent" theme="simple"/></td>
    			</tr>   
    		</table>	
    		<tr><td><s:submit key="submit" theme="simple"/></td></tr>
    	</s:form>
    	
    	<table>
    		<tr><th colspan="8"><s:text name="commentList"/></th></tr>
    		<s:iterator value="commentsList">
    		<tr><td><s:text name="content"/></td><td colspan="3"><s:property value="content"></s:property></td></tr>
    		<tr><td><s:text name="commentor"/></td><td><s:property value="username"/></td>
    			<td><s:text name="recordTime"/></td><td><s:property value="date"/></td>
    		</tr>
    		</s:iterator>
    	</table>
    </center>
  </body>
</html>
