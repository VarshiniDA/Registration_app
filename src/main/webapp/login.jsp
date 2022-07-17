<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h2>Login Here...</h2>
	<form action="verifyLogin" method="post">
		email<input type="text" name="email"/>
		password<input type="password" name="password"/>
		<input type="submit" value="login"/>
	</form>
	<%
		if(request.getAttribute("error")!=null){
			out.println(request.getAttribute("error"));
		}
	%>
</body>
</html>