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
    
    <title>My JSP 'plan_publisher.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/styles.css">

  </head>
  
  <body>
    <center>
    <s:text name="planByPubliser"/><br> 
        <br>
    	<s:text name="checkListForPlan"/>
    	<br> 
    	<s:form namespace="/" action="addNewPlanAction" method="post">
    		<table>
    		<tr><th><s:text name="date"></s:text></th>
    			<th><s:text name="planContent"/></th>
    			<th><s:text name="planTime"/></th>
    		</tr>
    		<s:iterator value="processDayListStr" id="dateList">
    		<tr><td><s:property value="dateList" id="dateList"/></td>
    			<td><s:textfield name="planContent" id="planContent" theme="simple"/></td>
    			<td><s:textfield name="planTime" id="planTime" theme="simple"/></td>
    		</tr>
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
    </center>
  </body>
</html>
