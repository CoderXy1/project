<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link type="text/css" href="css/main.css" rel="stylesheet">
<link type="text/css" href="css/0001245c2.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<style>
.a {
	width: 300px;
	height: 160px;
	margin: 200px auto;
	border-radius: 20px;
	box-shadow: 5px 5px gray;
	background-color: rgba(255, 255, 255, .5);
	text-align: center;
}
</style>

</head>
<body style="background-color: #CCCCCC">

	<div id="e_background">
		<div id="e_smallstars"></div>
		<div id="e_moon"></div>
		<div
			style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei'; color: #ffffff">
		
			<div class="container">

			<form class="form" action="login" method="post">
				<input type="text" placeholder="用户名" name="name">
				<input type="password" placeholder="密码" name="pass">
				<button type="submit" id="login-button">登录</button>
			</form>
		</div>

		</div>
	</div>
		
</body>
</html>