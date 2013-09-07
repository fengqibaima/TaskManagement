<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% String state = (String) session.getAttribute("tempState"); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'note_show_now.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
    <center>
    	<s:text name="viewNote"/><br>
    	<s:form namespace="/" action="editPublisherPlanAction" method="post"> 
    	<table>
    		<tr><th colspan="1"><s:text name="title"/></th><td colspan="7"  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.title"/></td></tr>
    		<tr><th colspan="1"><s:text name="content"/></th><td colspan="7"  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.content"/></td></tr>
    		<tr><th><s:text name="recordTime"/></th><td bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="recordTime"></s:property></td>
    			<th><s:text name="priority"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.priority.chname"/></td>
    			<th><s:text name="startTime"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="startTime"/>
    			<th><s:text name="endTime"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="endTime"/></td>
    		</tr>
    		<tr><th><s:text name="state"/></th>
    			<td bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:select list="stateList" name="stateid" listKey="id" listValue="name" theme="simple"></s:select></td>
    			<th><s:text name="category"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:property value="note.category.chname"/></td>
    			<th><s:text name="publisher"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:iterator value="publishersList"><s:property value="realname"></s:property>&nbsp;&nbsp;</s:iterator></td>
    			<th><s:text name="executor"/></th><td  bordercolor="#9EA7AB" bgcolor="#DFEFFD"><s:iterator value="executorsList"><s:property value="realname"></s:property>&nbsp;&nbsp;</s:iterator></td>
    		</tr>
    	</table>
    	
    	<br>
    	<s:text name="checkListForPlan"/>
    	<br>    	
    	<table>
    		<tr><th><s:text name="date"></s:text></th>
    			<th><s:text name="planContent"/></th>
    			<th><s:text name="planComment"/></th>
    			<th><s:text name="planTime"/></th>
    			<th><s:text name="usedTime"/></th>
    			<th><s:text name="percentage"/></th>
    		</tr>
    		<s:iterator value="planList" id="planList">
    		<tr><td><s:property value="date"/></td>
    			<td><s:property value="content"/></td>
    			<td><s:property value="comment"/></td>
    			<td><s:property value="expectedtime"/></td>
    			<td><s:property value="usedtime"/></td>
    			<% if(!state.equals("end")){%>
      			<td><s:textfield name="percentage" id="percentage" theme="simple"/></td>  				
    			<% }else{ %>
    			<td><s:property value="percentage"/></td>
    			<%} %>
    		</tr>
    		</s:iterator>
    		<tr><td><s:submit name="submit" key="submit" theme="simple"/></td></tr>
 		</table>
		
		<br>    	
    	<table>
    		<tr><th colspan="8"><s:text name="newComment"/></th></tr>
    		<tr><th colspan="1"><s:text name="content"/></th><td colspan="6"><s:textfield name="commentContent" key="commentContent" theme="simple"/></td><td colspan="1"><s:submit name="submit" key="submit" theme="simple"/></tr>   
    	</table>	
    	</s:form>
    	
    	<table>
    		<tr><th  colspan="8"><s:text name="commentList"/></th></tr>
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
