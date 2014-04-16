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
<%@ include file="../shared/studentMenu.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-md-12">
<%@ page import="omniSpectrum.Quizzium.Models.Quiz" %>
<%  Quiz currentQuiz = (Quiz)request.getAttribute("currentQuiz"); %>

	<h3><%=currentQuiz.getName() %></h3>
	
	<form name="studentAttemptForm" action="studentAttempt" method="POST">
	
	<div>
		<p>Student number
		<input type="text" name="studentNumber" />
	</div>
	
	<%
	String[] dummyQuestionList = {"What is 1?", "What is 2", "What is 3?"};
	//TODO FOR LOOP for question in Quiz.questions
	
	for(String question : dummyQuestionList){
	%>
		<div class="questionBlock">
			<p> <%= question %><br />
			<%
			String[] dummyAnswerList = {"42", "35", "64", "12"};
			//TODO FOR LOOP for answerAlternatives in questions.answerAlternatives
			
			for(String answerOption : dummyAnswerList){
			%>
				<input type="radio" name="
							<%=question%>" value=" <%=answerOption %> " />
							<%=answerOption%> <br />
			<% 
			}
			%>
		</div><!--END of div.questionBlock-->
	<% 
	}%>
	
	<input type="submit" value="Submit answers" />
	
	</form><!--END of form.studentAttemptForm-->
	</d
	iv>
</div>

<%@ include file="../shared/footer.jsp" %>
</div>

</body>
</html>