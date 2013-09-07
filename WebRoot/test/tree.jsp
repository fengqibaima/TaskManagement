<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 </head>
 <body bgcolor="EFF1FE" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
 <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
     <td > <table width="180" height="100%" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="180" height="100%" class="menu">
             <IFRAME width=180 height=100% src="showMenu.jsp"></IFRAME></td>
           <td></td>
         </tr>
       </table></td>
   </tr>
 </table>
 </body>
 </html>
