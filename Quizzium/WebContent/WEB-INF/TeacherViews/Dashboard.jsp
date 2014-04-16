<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>
<%@ page import="omniSpectrum.Quizzium.Models.Quiz" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>

</head>
<body>
	<%@ include file="../shared/teacherMenu.jsp" %>

	<%  @SuppressWarnings("unchecked") // Uncheck casting suppress
		ArrayList<Quiz> quizList = (ArrayList<Quiz>)request.getAttribute("quizList");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); %>
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
			<th>State</th>
		</tr>
		<% for(Quiz q : quizList){ %>
			
			<tr>
				<td><%=q.getName() %></td>
				<td><%=df.format(q.getCreatedAt()) %></td>
				<td><%=q.getCreatedBy().getLastName() %></td>
				<td><%=q.getQuestions().size() %></td>
				<td> ON / OFF <%-- TODO some switch On/off element --%></td>
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