<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" type="text/css" href="themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>

<body class="easyui-layout" onload="time()">

	<%
		//检测登录状态
		if (session.getAttribute("isLogin") == null) {
			out.print("<script>alert('用户未登录!');window.location.href='index.jsp'</script>");
		}
	%>

	<div data-options="region:'north',collapsible:false"
		style="height: 60px; background-color: #2A3542">
		<div align="right">
			<h5 id="time" style="color: #ffffff;float:left"></h5>
			<a href="#" style="color: #ffffff;margin:0 auto">1564</a>
		</div>
	</div>
	<div data-options="region:'west',title:'导航栏',split:true"
		style="width: 220px; background-color: #2A3542; color: #ffffff">
		<!-- 使用tree组件 -->
		<ul id="tt" style="padding: 20px; color: #CCCCCC"></ul>
	</div>
	<div id="center" data-options="region:'center'"
		style="padding: 5px; background: #eee;">

		<div id="tabs" class="easyui-tabs" style="width: 100%; height: 100%;">

		</div>

	</div>

	<script type="text/javascript">
		function time() {
			//获得显示时间的div
			t_div = document.getElementById('time');
			var now = new Date()
			t_div.innerHTML = now.getFullYear() + "-" + (now.getMonth() + 1)
					+ "-" + now.getDate() + " " + now.getHours() + ":"
					+ now.getMinutes() + ":" + now.getSeconds();
			setTimeout(time, 1000);
		}

		$(function() {
			$('#tt')
					.tree(
							{
								url : 'menu',
								animate : true,
								onLoadSuccess : function(node, data) {
									$('#tt').tree('collapseAll')
								},
								onClick : function(node) {
									if (node.attributes) {
										var flag = $('#tabs').tabs('exists',
												node.text)
										if (flag) {
											$('#tabs')
													.tabs('select', node.text);
										} else {
											console.log(node)
											//添加新的tab
											$('#tabs')
													.tabs(
															'add',
															{
																title : node.text,
																closable : true,
																content : "<iframe src='"
																		+ node.attributes.path
																		+ "' frameborder='0' width='100%' height='100%' >"
															});
										}

									}
								}
							});
		})
	</script>


</body>


</html>