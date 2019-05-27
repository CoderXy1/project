<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" href="themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>

<body>
	<div id="p" class="easyui-panel" title="当前位置：部门管理 > 部门查询"
		style="width: full; height: full; padding: 10px; background: #fafafa;">
		<div
			style="background: #fafafa; padding: 10px; width: 100%; height: full; border: 1px solid #ccc"">

			部门名称 <input id="deptName" class="easyui-textbox" style="width: 300px"> <a
				id="btn_search" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onclick="post()">搜索</a> <a id="btn_delete"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="deleteSelect()">删除</a>
		</div>

		<table id="dg" class="easyui-datagrid" width=100% data-options="url:'searchDept',pagination:true,striped:true">

			<thead>
				<tr>
					<th data-options="field:'checkbox'" checkbox="true" resizable=false></th>
					<th data-options="field:'did'" width=25% resizable=false>
						部门编号</th>
					<th data-options="field:'name'" width=25% resizable=false>
						部门名称</th>
					<th data-options="field:'info'" width=49% resizable=false>详细信息</th>
				</tr>
			</thead>
		</table>
	
	<script type="text/javascript">
	
	function post(){	
		$('#dg').datagrid({
				url : "searchDept",
				type : "post",
				queryParams : {
					"deptName" : $('#deptName').val(),
				}
			});
	}
	
	function deleteSelect(){
		
		var power = "<%=session.getAttribute("power")%>";
		if (power == "普通用户"){
			alert("你没有权限操作");
			return;
		}
		
		var a = $('#dg').datagrid('getSelections');
		if (a.length <= 0){
			alert("请至少选择一行");
		}else{
			console.log(a);
			$.ajax({
				type : "POST", //传数据的方式
				url : "deleteDept", //servlet地址
				data : {
					"did": JSON.stringify(a),
					"deptName" : $('#deptName').val(),
				}, //传的数据  form表单 里面的数据
				success : function(result) { //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
					post();
				}
			});
		}
		
	}
</script>
	
</body>
</html>