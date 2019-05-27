<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>yes2</title>
<link rel="stylesheet" type="text/css" href="themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"></script>
</head>
<body>
	
	<%
		String power = (String)session.getAttribute("power");
		if (power.equals("普通用户")){
			out.print("<script>alert('你没有该权限操作!');window.location.href='Error.jsp'</script>");
		}
	%>
	
	<div id="cc" class="easyui-layout" style="width: 100%; height: 630px">
		<div data-options="region:'center',title:'当前位置：公告管理 > 添加公告'"
			style="padding: 10px; background: #FFFFFF;">
			<form id="form">
				<table bgcolor="#F5F5F5" border="0" bordercolor="#8B7E66"
					cellpadding="0" cellspacing="10">
					<tr>
						<td>公告标题：<input type="text" class="easyui-textbox" name="title" size="30" id="title" />
						</td>
					</tr>
					<tr>
						<td>公告内容：<br /> <textarea name="content" cols="80" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="1" align="center"><a id="btn" href="#"
							class="easyui-linkbutton" data-options="iconCls:'icon-add'"
							onclick="checkAdd()">添加</a> <a id="btn" href="#"
							style="margin-left: 40px" class="easyui-linkbutton"
							data-options="iconCls:'icon-clear'"
							onclick="window.location.href = 'addNotice.jsp'">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		function checkAdd() {
			if ($("[name='title']").val() == '') {
				alert("标题不能为空");
				return;
			}
			if ($("[name='content']").val() == '') {
				alert("内容不能为空");
				return;
			}

			add();
		}

		function add() {
			$.ajax({
				type : "POST", //传数据的方式
				url : "addNotice", //servlet地址
				data : $('#form').serialize(), //传的数据  form表单 里面的数据
				success : function(result) { //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
					alert('添加成功!');
					window.location.href = 'addNotice.jsp';
				}
			});
		}
	</script>

</body>
</html>