<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>
<%@ page import="omniSpectrum.Quizzium.Models.Quiz" %>
<%@ page import="omniSpectrum.Quizzium.Models.Student" %>
<%@ page import="omniSpectrum.Quizzium.Models.StudentAttempt" %>
<%@ page import="java.util.ArrayList" %>

</head>
<body>
	<%@ include file="../shared/teacherMenu.jsp" %>
	
	<%
		@SuppressWarnings("unchecked") // Uncheck casting suppress
		ArrayList<Student> sList = 
			(ArrayList<Student>)request.getAttribute("studentList");
		@SuppressWarnings("unchecked") // Uncheck casting suppress
		ArrayList<Quiz> qList = 
			(ArrayList<Quiz>)request.getAttribute("quizList");
	%>
	
<div class="container">
<div class="row">
	<div class="col-md-12">
	<div class="panel panel-info">
	<div class="panel-heading">Grading Table</div>
	<table class="table table-striped">
		<tr>
			<th>&nbsp;<!-- THIS CEll initially left blank --></th>
			
			<% for(Quiz q : qList){%>
				<th><%=q.getName() %></th>
			<% } %>
			
			<th>Mean</th>
		</tr>
		
		<% for(Student s : sList){ %>
			<tr>
				<td>a<%=s.getStudentNumber() %></td>
				
				<% double sum = 0;
				   
					for(Quiz q : qList){
						Boolean temp = Boolean.FALSE;
				      for(StudentAttempt att : s.getAttempts()){
				    	 temp = q.getId() == att.getQuiz().getId();
				    	 
				      	 if(temp){ 
				      		sum += att.getResult();
				%>
							<td><%= att.getResult() %></td>							
				<% 			break;
						 }
					  } //End of Att for
				      
				      if(!temp) {
				%>
						<td>_</td> 						
				<%	  } 
				    } //End of Quiz for 
				%>
				 			 
				 <td><%=(sum/s.getAttempts().size())%></td>				    
			</tr>
		<% } //End of Student FOR %>
		
	</table>
	</div>
		
	<%@ include file="../shared/footer.jsp" %>
	</div>
	</div>
</div>
</body>
</html>