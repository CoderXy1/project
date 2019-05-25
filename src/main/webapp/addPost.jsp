<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>职位添加</title>
</head>
<link rel="stylesheet" type="text/css" href="themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="p" class="easyui-panel" title="当前位置：职位管理 > 添加职位"
		style="width: full; height: full; padding: 10px; background: #fafafa;">
		<form id="form">
			<table>
				<tr>
					<td>职位名称:</td>
					<td><input name="postName" class="easyui-textbox"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>详细描述:</td>
					<td><input name="describe" class="easyui-textbox"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><a id="btn_add"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						onclick="checkAdd()">添加</a> <a id="btn_clear" class="easyui-linkbutton"
						data-options="iconCls:'icon-clear'" style="margin-left: 50px"
						onclick="window.location.href = 'addPost.jsp'">清空</a></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
		
		function checkAdd() {
			if ($("[name='postName']").val() == '') {
				alert("职位名称不能为空");
				return ;
			}
			if ($("[name='describe']").val() == '') {
				alert("详细描述不能为空");
				return ;
			}
			
			add();
		}
			
			function add() {
				$.ajax({
					type : "POST", //传数据的方式
					url : "addPost", //servlet地址
					data : $('#form').serialize(), //传的数据  form表单 里面的数据
					success : function(result) { //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
						alert('添加成功!');
						window.location.href = 'addPost.jsp';
					}
				});
			}

		</script>
</body>
</html>