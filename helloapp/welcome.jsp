<%@ taglib uri="/mytaglib" prefix="mm" %>
<html>
	<head>
		<title>helloapp</title>
	</head>
	<body>
		<b>Welcome to my website, <%=request.getAttribute("USER")%></b>
	</body>
</html>
