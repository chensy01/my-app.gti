<html>
	<head>
		<title>helloapp</title>
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
					<td><input type="Submit" name="Submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
