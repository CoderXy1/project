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
<link rel="stylesheet" type="text/css" href="css/nav.css">
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
		
<!-- 顶部导航栏 -->
	<div>
		<img alt="第七组logo" src="img/logo.png" style="epadding:0;marging:0;float:left;">
	</div>
	<div>
		<h3 align="center" style="padding:0;margin-left:450px;float:left;color: white">人力资源管理系统</h3>
	</div>
	<ul id="nav"> 
		<li><a href="javascript:void(0);" onclick="js_method1()"><img alt="退出图片" src="img/systools.png" style="padding-right:5px;">退出登录</a></li> 
		<li><a href="javascript:void(0);" onclick="js_method2()"><img alt="设置图片" src="img/pointer.png" style="padding-right:5px;">用户注册</a></li> 
		<li><a href="javascript:void(0);" onclick="js_method3()"><img alt="设置图片" src="img/pointer.png" style="padding-right:5px;">修改密码</a></li> 
		<li><a href="javascript:void(0);" onclick="js_method4()"><img alt="闹钟图片" src="img/StatBar_time.png" style="padding-right:5px;"><font id="time" style="color: #ffffff;"></font></a></li> 
		<li><a href="javascript:void(0);" onclick="js_method5()"><img alt="用户图片" src="img/home.png" style="padding-right:5px;">欢迎登录:<%=session.getAttribute("uname") %></a></li> 
	</ul> 

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