<%@ page language="java" import="java.util.*,com.coder.model.*,com.coder.dao.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统——员工查询</title>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>

</head>
<body>
	<div data-options="region:'center',title:'当前位置：用户管理 > 用户查询'"
		style="width: full; height: full; padding: 10px; background: #eee;">
		<div id="p" class="easyui-panel"
			style="width: 100%; height: 50px; background: #fafafa; padding: 5px;"
			data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true,noheader:true,edge:10">
			<table >
				<tr>
					<td>姓名:</td>
					<td><input id="wName" name="wName" class="easyui-textbox" style="width: 300px"
						data-options="required:false" /></td>
					<td>部门:</td>
					<td><select id="dName" class="easyui-combobox" name="dName"
						style="width: 300px;">
							<option>全部</option>
							<%
								Dao dao = new Dao();
								List<DeptInfo> list = dao.getAllDept("");
								for (int i = 0; i < list.size(); i++) {
							%>
							<option><%=list.get(i).getName()%></option>
							<%
								}
							%>
					</select></td>
					<td><a id="btn_search" class="easyui-linkbutton"
						data-options="iconCls:'icon-search',text:'搜索'" onclick="post()"></a></td>
					<td><a id="btn_delete" class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel',text:'删除'"
						onclick="deleteSelect()"></a></td>
				</tr>
			</table>
			
			</div>

		<div id="xx"
			style="width: 100%; height: 90%; background: #fafafa; margin-top: 10px">

			<table class="easyui-datagrid" id="dg"
				data-options="url:'searchWorker',pagination:true,striped:true">
				<thead>
					<tr>
						<th data-options="field:'checkbox'" checkbox="true" resizable=false></th>
						<th data-options="field:'wId'" width="40" align="center">编号</th>
						<th data-options="field:'wName'" width="100" align="center">姓名</th>
						<th data-options="field:'sex'" width="40" align="center">性别</th>
						<th data-options="field:'phone'" width="150" align="center">手机号码</th>
						<th data-options="field:'email'" width="200" align="center">邮箱</th>
						<th data-options="field:'PName'" width="100" align="center">职位</th>
						<th data-options="field:'education'" width="100" align="center">学历</th>
						<th data-options="field:'idNumber'" width="150" align="center">身份证号码</th>
						<th data-options="field:'major'" width="150" align="center">专业</th>
						<th data-options="field:'address'" width="250" align="center">联系地址</th>
						<th data-options="field:'birthday'" width="100" align="center">生日</th>
						<th data-options="field:'interests'" width="150" align="center">爱好</th>
						<th data-options="field:'qq'" width="150" align="center">qq</th>
						<th data-options="field:'political'" width="100" align="center">政治面貌</th>
						<th data-options="field:'postcode'" width="100" align="center">邮政编码</th>
						<th data-options="field:'family'" width="80" align="center">名族</th>
						<th data-options="field:'major'" width="100" align="center">专业</th>
						<th data-options="field:'remarks'" width="250" align="center">备注</th>
						<th data-options="field:'dName'" width="100" align="center">部门</th>
					</tr>
				</thead>

			</table>

		</div>

	</div>

	<script type="text/javascript">
		function post() {
			$('#dg').datagrid({
				url : "searchWorker",
				type : "post",
				queryParams : {
					"wName" : $('#wName').val(),
					"dName" : $('#dName').val(),
				}
			});
		}

		function deleteSelect() {

			var a = $('#dg').datagrid('getSelections');
			if (a.length <= 0) {
				alert("请至少选择一行");
			} else {
				console.log(a);
				$.ajax({
					type : "POST", //传数据的方式
					url : "deleteWorker", //servlet地址
					data : {
						"wid" : JSON.stringify(a),
						"uname" : $('#uname').val(),
						"power" : $('#power').val(),
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