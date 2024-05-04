<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</p>

	<form action="login" method="post">
		<input type="text" name="userName"><br> <input
			type="submit" value="Login">
	</form>
</body>
</html>