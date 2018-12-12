<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var basepath='<%=basePath%>';
</script>

<title>用户登录 -管理系统</title>


<script src="<%=basePath%>static/js/easyui/jquery.min.js"></script>
<script src="<%=basePath%>static/js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet"  href="<%=basePath%>static/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet"  href="<%=basePath%>static/js/easyui/themes/icon.css"/>


</head>

<body>
<div style="margin-left: 400px;margin-top: 250px;">
	<div >
		<form id="LoginForm" method="post" action="<%=basePath%>login/loginAdmin">
			<table class="tableStyle">
				<tr>
					<td class="title">用户名：</td>
					<td class="content">
						<input type="text"  name="username"  class="easyui-textbox" id="userName" maxlength="18" />
					</td>
				</tr>
				<tr>
					<td class="title">密&nbsp;&nbsp;&nbsp;码：</td>
					<td class="content">
						<input type="password" name="password"  class="easyui-textbox"  id="pwd" />
					</td>
				</tr>
			</table>
		<br/>
			<div class="serbut" style="width: 170px; text-align: right">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="login()">登陆</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-clear" onclick="clearForm()">清空</a>
			</div>
		</form>
	</div>
	<div style="margin-top: 200px;">
		<font color="red">管理系统</font> Version 1.0 由wool科技提供技术支持！ <br />
	</div>
	</div>
	<script type="text/javascript">
	var LoginAndReg;

	function login() {
		var username = $("#userName");
		var password = $("#pwd");

		if (username.val() == "") {
			$.messager.alert("提示","请输入用户名！");
			username.focus();
			return false;
		} else if (password.val() == "") {
			$.messager.alert("提示","请输入密码！");
			password.focus();
			return false;
		} else {
			$("#LoginForm").submit();
		}
	}
	
</script>
</body>
</html>