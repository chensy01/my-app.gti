<html>
	<head>
		<title>leave a message</title>
	</head>
	<body>
		<br>
		<form name="leaveMessage" method="post" action="dispatcher">
			<table>
				<tr>
					<td><div align="right">User Name:</div></td>
					<td><textarea rows="3" cols="20"></td>
				</tr>
				<tr>
					<input type="hidden" name="action" value="leavemessage"/>
				</tr>
				<tr>
					<td></td>
					<td><input type="Submit" name="Submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</body>
</html>