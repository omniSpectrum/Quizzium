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
<%@ include file="../shared/studentMenu.jsp"%> 
<%@ page import="omniSpectrum.Quizzium.dummy.Models.StudentAttempt"%>
<% StudentAttempt att = (StudentAttempt)request.getAttribute("AttemptRecord"); %>

<div class="container">
	<div class="jumbotron">
		<h1><%=(att.getResult() > 50)? "Congrats! =)" : "Sadly... :(" %></h1>
		<p class="lead">
			st.No.: <%= att.getStudent().getStudentNumber() %>	<br/>
			quiz: <%= att.getQuiz().getName() %> <br/>				
		</p>
		<h2>Result: <%= att.getResult() %> out of 100 <br/></h2>
	</div>
	<%@ include file="../shared/footer.jsp" %>
</div><!-- END Of div.container -->
</body>
</html>

