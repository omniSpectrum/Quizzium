<%@ page language="java" isErrorPage="true" 
 contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>

</head>
<body>
<%@ include file="../shared/studentMenu.jsp"%> 
<div class="container">
	<div class="jumbotron">
		<h1>Oooops!</h1>
		<h2>PAGE NOT FOUND! :(</h2>
		<p class="lead">
			Error code: ${pageContext.errorData.statusCode} <br/>
    		Request URI: ${header.host}${pageContext.errorData.requestURI}<br />
			
			<% String mess = (String)request.getAttribute("offMessage"); %>
			<%=(mess != null ? mess : "") %>
		</p>
	</div>
	<%@ include file="../shared/footer.jsp" %>
</div><!-- END Of div.container -->
</body>
</html>