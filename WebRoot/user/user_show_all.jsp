<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("path: "+path);
	//String path2 = pageContext.request.contextPath;
	//System.out.print("path2: "+path2);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'user_show_all.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="style/styles.css" rel="stylesheet" type="text/css">
		<!--  
	<style type="text/css">
	table, th, td
	{
		border: 1px solid black;
		border-collapse:collapse;
	}
	</style>
	-->

		<script src="library/jquery-1.10.2.js"></script>
	</head>

	<body>
		<center>
			<table>
				<tr>
					<th>
						<s:text name="username"></s:text>
					</th>
					<th>
						<s:text name="realname"></s:text>
					</th>
					<th>
						<s:text name="email"></s:text>
					</th>
					<th>
						<s:text name="department"></s:text>
					</th>
					<th>
						<s:text name="view"></s:text>
					</th>
					<th>
						<s:text name="edit"></s:text>
					</th>
					<th>
						<s:text name="delete"></s:text>
					</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td style="display:none" class="id">
							<s:property value="id" />
						</td>
						<td>
							<s:property value="username" />
						</td>
						<td onclick="aycnUpdateValue($(this))" class="realname">
							<s:property value="realname" />
						</td>
						<td>
							<s:property value="email" />
						</td>
						<td>
							<s:property value="department.name" />
						</td>
						<td>
							<a
								href="<%=path%>/showDetailUserAction.action?userId=<s:property value="id"/>"><s:text
									name="view" /> </a>
						</td>
						<td>
							<a
								href="<%=path%>/showEditOnePageUserAction.action?userId=<s:property value="id"/>"><s:text
									name="edit" /> </a>
						</td>
						<td>
							<a
								href="<%=path%>/deleteOneUserAction.action?userId=<s:property value="id"/>"><s:text
									name="delete" /> </a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td>
						<s:url id="url1" action="showAddNewPageUserAction.action"></s:url>
						<s:a href="%{url1}">
							<s:text name="addNew" />
						</s:a>
			</table>
		</center>
	</body>

	<script>
	
	function aycnUpdateValue2(node) {
		//取得当前节点的class
		var span = node;
		var oldText;
		if(span.children("input").tagName == "input"){
			oldText = span.children("input").val();
			alert("input"+oldText);
		}else{
			oldText = span.text();
			alert("text"+oldText);
			alert(span.children(text.TextEdit)[0].text());
		}
		span.empty();
		var input = $("<input type='text' value='"+oldText+"'/>");
		//dont have focus cant not click then edit
		input.val = input.appendTo(span).focus().select();
		
		//can keep the orignal value show
		//span.attr("onclick", "").unbind("click");

		input.blur(function() {
			var parent = $(this).parent();
			var input_blur = $(this);
			var newText = input_blur.val();
			if (newText != oldText) {
				//updateData(table, nodeClass,newText,ID); 
			}
			span.html(newText);
			parent.click(clickInputSecondStep);
		});

		input.keyup(function(event) {
			// 获取键值   
			var keyEvent = event || window.event;
			var key = keyEvent.keyCode;
			//获得当前对象   
			var parent = $(this).parent();
			var input_blur = $(this);
			switch (key) {
			case 13://按下回车键，保存当前文本框的内容   
				var newText = input_blur.val();
				//插入数据库，如果新旧数据不一样，则访问数据库
				if (newText != oldText) {
					//updateData(table, nodeClass,newText,ID); 
				}
				span.html(newText);
				parent.click(clickInputSecondStep);
				break;

			case 27://按下esc键，取消修改，把文本框变成文本    
				span.html(oldText);
				//重新加上点击事件
				parent.click(clickInputSecondStep);
				break;
			}
		});

	}

	function aycnUpdateValue(node) {
		//get id number
		var id = node.siblings(".id").text();
		var table = "user";
		var nodeClass = node.attr("class");
	
		var span = node;
		var oldText = span.text();
		span.empty();
		var input = $("<input type='text' value='"+oldText+"'/>");
		//input.appendTo(span).focus().select();
		//cant work without focus
		input.appendTo(span).focus();
		//can keep the orignal value show
		span.attr("onclick", "").unbind("click");

		input.blur(function() {
			var parent = $(this).parent();
			var input_blur = $(this);
			var newText = input_blur.val();
			if (newText != oldText) {
				updateData(table, nodeClass,newText,id); 
			}
			span.html(newText);
			parent.click(clickInputSecondStep);
		});

		input.keyup(function(event) {
			// 获取键值   
			var keyEvent = event || window.event;
			var key = keyEvent.keyCode;
			//获得当前对象   
			var parent = $(this).parent();
			var input_blur = $(this);
			switch (key) {
			case 13://按下回车键，保存当前文本框的内容   
				var newText = input_blur.val();
				//插入数据库，如果新旧数据不一样，则访问数据库
				if (newText != oldText) {
					//updateData(table, nodeClass,newText,ID); 
				}
				span.html(newText);
				parent.click(clickInputSecondStep);
				break;

			case 27://按下esc键，取消修改，把文本框变成文本    
				span.html(oldText);
				//重新加上点击事件
				parent.click(clickInputSecondStep);
				break;
			}
		});

	}

	//span标签取消onclick事件后，重新绑定click事件，用于：被访客户，被访客户职务
	function clickInputSecondStep() {
		var id = $(this).siblings(".id").text();
		var table = "user";
		var nodeClass = $(this).attr("class");
		
		var span = $(this);
		var oldText = span.text();
		span.empty();
		var input = $("<input type='text' value='"+oldText+"'/>");
		//将输入框添加到span中    	    
		//将jquery对象转化为DOM对象
		input.appendTo(span).focus().select();
		//input.appendTo(span).focus();
		//input.appendTo(span).select();
		span.unbind("click");
		var table = "B_SCPT_XMGZ_XMQK";

		input.blur(function() {
			var input_blur = $(this);
			var newText = input_blur.val();
			if (newText != oldText) {
				updateData(table, nodeClass,newText,id); 
			}
			span.html(newText);
			span.click(clickInputSecondStep);
		});

		input.keyup(function(event) {
			var keyEvent = event || window.event;
			var key = keyEvent.keyCode;
			var input_blur = $(this);
			switch (key) {
			case 13://按下回车键，保存当前文本框的内容   
				var newText = input_blur.val();
				if (newText != oldText) {
					updateData(table, nodeClass,newText,id); 
				}
				span.html(newText);
				span.click(clickInputSecondStep);
				break;

			case 27://按下esc键，取消修改，把文本框变成文本    
				span.html(oldText);
				span.click(clickInputSecondStep);
				break;
			}
		});
	}
	
		// 更新数据到项目跟踪表
	function updateData(table, updateCol,newData,ID){
	var path = location.protocol + "//" + location.host+"/WebTest1";
		var res;	
		try{   
			$.ajax({
				type: "post",
				//async: false,				
				url: path + "/ajax/XMGZupdateAjax.jsp?table=" + table + "&updateCol=" + updateCol +"&newData=" + newData + "&ID=" + ID,
				error: function(){
					alert("updateData error:function");  
					//alert(d); 
				},  
				complete: function(){
					//alert("updateData complete:function");
				},
				success: function(data){  
					//alert("updateData success:function");
				    //res = JSON.parse(data);  
				}
				 
			});
		}catch(e){
			res = null;
		}
		return res;
	}  
	
</script>
</html>
