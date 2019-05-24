<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$('#cc').combo({
		required : true,
		multiple : true
	});
</script>

<body>
	<div id="p" class="easyui-panel" title="当前位置：用户管理> 添加用户"
		style="width: full; height: full; padding: 10px; background: #fafafa;">
		<form id="form">
			<table boder=1px padding=10px>

				<tr>
					<td>姓 名</td>
					<td><input name="uname" class="easyui-textbox"
						style="width: 300px"></td>

				</tr>
				<tr>
					<td>权 限</td>
					<td><select name="power" class="easyui-combobox"
						style="width: 200px;">
							<option selected="selected">普通用户</option>
							<option>管理员</option>
					</select></td>
				</tr>
				<tr>
					<td>账 号</td>
					<td><input id="uid" name="uid" class="easyui-textbox"
						style="width: 300px"></td>
				</tr>
				<td>密 码</td>
				<td><input name="password" class="easyui-textbox"
					style="width: 300px"></td>
				<tr>
					<td colspan="2" align="center"><a id="btn" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						onclick="checkAdd()">添加</a> <a id="btn" href="#"
						style="margin-left: 40px" class="easyui-linkbutton"
						data-options="iconCls:'icon-clear'" onclick="window.location.href = 'addUser.jsp'">清空</a></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">
		function checkAdd() {
			if ($("[name='uname']").val() == '') {
				alert("姓名不能为空");
				return ;
			}
			if ($("[name='uid']").val() == '') {
				alert("账号不能为空");
				return ;
			}
			if ($("[name='password']").val() == '') {
				alert("密码不能为空");
				return ;
			}
			
			add();
		}

		function add() {
			$.ajax({
				type : "POST", //传数据的方式
				url : "addUser", //servlet地址
				data : $('#form').serialize(), //传的数据  form表单 里面的数据
				success : function(result) { //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
					alert('添加成功!');
					window.location.href = 'addUser.jsp';
				}
			});
		}
	</script>

</body>
</html>