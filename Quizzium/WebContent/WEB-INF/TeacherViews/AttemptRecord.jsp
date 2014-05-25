<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>

<%@ page import="omniSpectrum.Quizzium.Models.StudentAttempt" %>
<%@ page import="omniSpectrum.Quizzium.Models.Question" %>
<%@ page import="omniSpectrum.Quizzium.Models.Alternative" %>
<%@ page import="omniSpectrum.Quizzium.Models.StudentAnswers" %>
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
				<h4>Quiz: <%=att.getQuizz().getName() %> 
					<small><%= new SimpleDateFormat("dd.MM.yyyy").format(att.getAttemptDate()) %></small></h4>
				<h4>st.No.: <%=att.getStudent().getStudentNumber() %></h4>
				<h4>Result: <%=att.getResult() %>%</h4>
			</div>
		</div>
		
		<% for (Question question : att.getQuizz().getQuestions()) { %>
			<div class="form-group">
				<p> <%=question.getDescription()%> </p>
						
				<% for (Alternative answerOption : question.getAlternatives()) { 
					Boolean isCorrect = 
							answerOption.getAlternativeId() == question.getCorrectAnswers().iterator().next()
																		.getAlternative().getAlternativeId();
				%>
					<div class="radio">
						<label> 
							<input type="radio" disabled 
						<%for(StudentAnswers actualAnswer : att.getStudentAnswerses()){ 	
							if(actualAnswer.getAlternative().getAlternativeId() == answerOption.getAlternativeId()){
								out.print("checked");
							}							
						} %>
								name="<%=question.getQuestionId()%>"
								value="<%=answerOption.getAlternativeId()%>" /> 
								<%=answerOption.getDescription()%>
								
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