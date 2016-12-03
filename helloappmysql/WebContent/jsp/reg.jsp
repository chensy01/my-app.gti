<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register your account</title>
</head>
<body>
	<br>
		<form name="reginstForm" method="post" action="register.action">
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
					<input type="hidden" name="action" value="register"/>
				</tr>
				<tr>
					<td></td>
					<td><input type="Submit" name="Submit" value="注册"></td>
				</tr>
			</table>
		</form>

</body>
</html>