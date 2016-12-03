<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
		<br>
		<form name="loginForm" method="post" action="login.action">
			<table>
				<tr>
					<td><div align="right">User Name:</div></td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td><div align="right">Password:</div></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<input type="hidden" name="action" value="login"/>
				</tr>
				<tr>
					<td></td>
					<td><input type="Submit" name="Submit" value="登录"></td>
				</tr>
			</table>
		</form>
	</body>
</html>