<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>

<%@ page import="omniSpectrum.Quizzium.Models.Quizz" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

</head>
<body>
	<%@ include file="../shared/teacherMenu.jsp" %>

	<%  @SuppressWarnings("unchecked") // Uncheck casting suppress
		List<Quizz> quizList = (List<Quizz>)request.getAttribute("quizList");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dfQuiz = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	%>
<div class="container">
<div class="row">
	<div class="col-md-12">
	<div class="panel panel-info">
	<div class="panel-heading">Quiz List</div>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<th>Created At</th>
			<th>Created By</th>
			<th>Questions</th>
			<th>Start</th>
			<th>End</th>
		</tr>
		<% for(Quizz q : quizList){ %>
			
			<tr>
				<td><%=q.getName() %></td>
				<td><%=df.format(q.getCreatedAt()) %></td>
				<td><%=q.getTeacher().getFirstName() + " " + q.getTeacher().getLastName() %></td>
				<td><%=q.getQuestions().size() %></td>
				<td><% if(q.getQuizzStarted() != null) 
						out.print(dfQuiz.format(q.getQuizzStarted())); %> 
				</td>
				<td><% if(q.getQuizzEnded() != null) 
						out.print(dfQuiz.format(q.getQuizzEnded())); %> 
				</td>
			</tr>
			
		<%} //End of For loop%>
	</table>
	</div>
			
	<%@ include file="../shared/footer.jsp" %>
	</div>
	</div>
</div>

</body>
</html>