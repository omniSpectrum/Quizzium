<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>
<link rel="stylesheet" href="/Quizzium/res/css/bootstrap-switch.min.css" />

<%@ page import="omniSpectrum.Quizzium.Models.StudentAttempt" %>
<%@ page import="omniSpectrum.Quizzium.Models.Question" %>
<%@ page import="omniSpectrum.Quizzium.Models.AnswerAlternative" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>

</head>
<body>
	<%@ include file="../shared/teacherMenu.jsp" %>
<div class="container">
<div class="row">
	<div class="col-md-12">
		<%StudentAttempt att = (StudentAttempt)request.getAttribute("attempt"); %>
		<div class="panel panel-info">
			<div class="panel-heading">Attempt Record</div>
			<div class="panel-body">
				<h4>Quiz: <%=att.getQuiz().getName() %> <small><%= new SimpleDateFormat("dd.MM.yyyy").format(att.getAttemptDate()) %></small></h4>
				<h4>st.No.: a<%=att.getStudent().getStudentNumber() %></h4>
				<h4>Result: <%=att.getResult() %>%</h4>
			</div>
		</div>
		
		<% for (Question question : att.getQuiz().getQuestions()) { %>
			<div class="form-group">
				<p> <%=question.getQuestionText()%> </p>
						
				<% for (AnswerAlternative answerOption : question.getAnswerOptions()) { 
					Boolean isCorrect = 
							answerOption.getAlternativeId() == question.getCorrectAnswer().getAlternativeId();
				%>
					<div class="radio">
						<label> 
							<input type="radio" disabled 
						<%for(AnswerAlternative actualAnswer : att.getStudentAnswers()){ 	
							if(actualAnswer.getAlternativeId() == answerOption.getAlternativeId()){
								out.print("checked");
							}							
						} %>
								name="<%=question.getQuestionId()%>"
								value="<%=answerOption.getAlternativeId()%>" /> 
								<%=answerOption.getAnswerText()%>
								
								<%="<span class=\"" + (isCorrect?
										"glyphicon glyphicon-ok text-success"
										: "glyphicon glyphicon-remove text-danger")
									+ "\"></span>"%>
						</label>
					</div>
				<%
					} // END for(answerOptions)
				%>
			</div><!--END of div.formgroup -->
		<%
			} // END for(questions)
		%>
		
		<%@ include file="../shared/footer.jsp" %>
	</div>
</div>
</div>
</body>
</html>