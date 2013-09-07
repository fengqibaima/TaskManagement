<%@page import="java.util.*"%>
<%@page import="com.ascent.ajax.UpdateAjax" %>
<%@page import="com.ascent.ajax.SpringContextUtils" %>
<%
	response.setHeader("Cache-Control", "no-cache");
	//response.setContentType("/text;charset=GBK");
	request.setCharacterEncoding("GBK");	

	String table = request.getParameter("table"); 
	String ID = request.getParameter("ID"); 
	String updateCol = request.getParameter("updateCol");
	String updateData = request.getParameter("newData");
	
	//UpdateAjax updateAjax = new UpdateAjax();
	UpdateAjax updateAjax = (UpdateAjax)SpringContextUtils.getBean("UpdateAjax");
	updateAjax.updateSql(table,updateCol, updateData, ID);
    out.print("table "+table);
    out.print("ID "+ID);
    out.print("updateCol "+updateCol);
    out.print("updateData "+updateData);
	out.print("OK"); 

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("text/html;charset=GBK");	 
	//out.close();
%> 