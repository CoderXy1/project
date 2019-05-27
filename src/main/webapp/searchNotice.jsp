<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>yes</title>
<link rel="stylesheet" type="text/css" href="themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function dianji() {
		$('#win').window({
			width : 600,
			height : 400,
			modal : true
		});
	}
</script>
</head>
<body>
	<div id="win" title="公告预览"></div>
	<div id="p" class="easyui-panel" title="当前位置：公告管理 > 公告查询"
		style="width: 100%;padding: 10px; background: #fafafa;">
		<div style="padding: 10px; border: 1px">

<div id="p" class="easyui-panel"
			style="width: 100%; background: #fafafa; padding: 5px;"
			data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true,noheader:true,edge:10">
			<table>
				<tr>
					<td>公告名称</td>
					<td><input id="title" class="easyui-textbox" style="width: 300px"
						data-options="required:false" /></td>
					<td>公告内容</td>
					<td><input id="content" class="easyui-textbox" style="width: 300px"
						data-options="required:false" /></td>
					<td><a id="btn_search" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',text:'搜索'" onclick="post()"></a></td>
					<td><a id="btn_delete" class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel',text:'删除'" onclick="deleteSelect()"></a></td>
				</tr>
			</table>

		<table class="easyui-datagrid" id="dg"
				data-options="pagination:true,striped:true,url:'searchNotice'">
			<thead>
				<tr>
					<th data-options="field:'ck'" checkbox="true"></th>
					<th data-options="field:'name'" width=20%>公告名称</th>
					<th data-options="field:'content'" width=45%>公告内容</th>
					<th data-options="field:'time'" width=19.45%>公告时间</th>
					<th data-options="field:'uid'" width=15%>公告人</th>
				</tr>
			</thead>
		</table>
	
	<script type="text/javascript">
	
	function post(){	
		$('#dg').datagrid({
				url : "searchNotice",
				type : "post",
				queryParams : {
					"title" : $('#title').val(),
					"content" : $('#content').val(),
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
				url : "deleteNotice", //servlet地址
				data : {
					"did": JSON.stringify(a),
					"title" : $('#title').val(),
					"content" : $('#content').val(),
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