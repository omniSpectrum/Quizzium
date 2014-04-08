<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>
</head>
<body>
<h1>Quizzium</h1>
<hr />

<h4>Please Log in</h4>
<form action="LogIn">
	<input type="text" name="login"/>
	<input type="password" name="password"/>
	
	<input type="submit" value="Sign In" />
</form>

<%@ include file="../shared/footer.jsp" %>
</body>
</html>