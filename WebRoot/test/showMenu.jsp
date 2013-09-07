<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page  import="java.io.OutputStream" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

 String defaultCharset = "GB2312";
 response.setContentType("text/html; charset=" + defaultCharset);
 OutputStream os = response.getOutputStream();
 
 StringBuffer menuTree = new StringBuffer();
 menuTree.append("<html>");
 menuTree.append("<head>");
 menuTree.append("    <script language=JavaScript>");
 menuTree.append("        function showMenu(elementId)");
 menuTree.append("        {");
 menuTree.append("          var obj = document.getElementById(elementId);");
 menuTree.append("         if (obj.style.display == \"\")");
 menuTree.append("         {");
 menuTree.append("            obj.style.display=\"none\";");
 menuTree.append("          }");
 menuTree.append("          else");
 menuTree.append("          {");
 menuTree.append("            obj.style.display=\"\";");
 menuTree.append("          }");
 menuTree.append("        }");
 menuTree.append("    </script>");
 menuTree.append("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset="
         + defaultCharset + "\">");
 menuTree.append("</head>");
 menuTree.append("<body bgcolor=\"EFF1FE\" leftmargin=\"0\" topmargin=0 marginwidth=0 marginheight=0>");
 menuTree.append("    <form name=\"fm\" method=\"post\">");
 //添加一级菜单
 menuTree.append("<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
 
 menuTree.append("  <tr>");
 menuTree.append("    <td height=\"25\" onclick=\"showMenu('menu2')\">");
 menuTree.append(" <font color=\"#000000\" size=\"2pt\">      菜单1</font>");
 menuTree.append("     </td>");
 menuTree.append("  </tr>");
 
 menuTree.append("  <tr>");
 menuTree.append("  <td>");
 menuTree.append("<table style=\"display:none\" id=\"menu2\" width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
 menuTree.append("  <tr>");
 menuTree.append("    <td height=\"25\" onclick=\"showMenu('menu3')\">");
 menuTree.append(" &nbsp;&nbsp;&nbsp;&nbsp;菜单1-2");
 menuTree.append("     </td>");
 menuTree.append("  </tr>");
 menuTree.append("</table>");
 menuTree.append("     </td>");
 menuTree.append("  </tr>");
 
 menuTree.append("  <tr>");
 menuTree.append("  <td>");
 menuTree.append("<table style=\"display:none\" id=\"menu3\" width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
 menuTree.append("  <tr>");
 menuTree.append("    <td height=\"25\" >");
 menuTree.append(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜单1-3");
 menuTree.append("     </td>");
 menuTree.append("  </tr>");
 menuTree.append("</table>");
 menuTree.append("     </td>");
 menuTree.append("  </tr>");
 
 
 menuTree.append("  <tr>");
 menuTree.append("    <td height=\"25\">");
 menuTree.append("       菜单2");
 menuTree.append("     </td>");
 menuTree.append("  </tr>");
 
 menuTree.append("</table>");
 
 menuTree.append("    </form>");
 menuTree.append("</body>");
 menuTree.append("<html>");
 
 os.write(menuTree.toString().getBytes());
 os.flush();
 os.close();
 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
