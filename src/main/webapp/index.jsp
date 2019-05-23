<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
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

	<form action="login" method="post">
		<table class="a">
			<tr>
				<td height="40">用户名:</td>
				<td height="40"><input class="easyui-textbox" name="name"
					data-options="iconCls:'icon-man'" style="width: 200px" required="required"></td>
			</tr>
			<tr>
				<td height="40">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td height="40"><input class="easyui-passwordbox" name="pass"
					prompt="Password" iconWidth="28" style="width: 200px"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40"><input type="submit"
					value="登录"
					style="width: 100px; height: 30px; background-color: #CCCCCC;border-radius: 20px" required="required"></td>
			</tr>
		</table>
	</form>


</body>
</html>