<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp"%>
</head>
<body>
	<%@ include file="../shared/studentMenu.jsp"%> 

	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.Collections"%>
	<%@ page import="java.util.Collection"%>
	
	<%@ page import="omniSpectrum.Quizzium.Models.Quizz"%>
	<%@ page import="omniSpectrum.Quizzium.Models.Question"%>
	<%@ page import="omniSpectrum.Quizzium.Models.Alternative"%>
	
	<% Quizz currentQuiz = (Quizz) request.getAttribute("currentQuiz"); 
		List<Question> myQues = new ArrayList<Question>(currentQuiz.getQuestions());
		Collections.shuffle(myQues);
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3><%=currentQuiz.getName()%></h3>

				<form name="studentAttemptForm" role="form"
					action="Attempt" method="POST">

					<div class="form-group">
						Student number &nbsp;
						<input type="text" name="studentNumber" 
							data-validation="custom" 
							data-validation-regexp="^(a[0-9]{7})$"
							data-validation-error-msg="Student number in format a123456" />
					</div>
					<% for (Question question : myQues) { %>

					<div class="form-group">
						<p> <%=question.getDescription()%> </p>
						
						<% List<Alternative> alts = new ArrayList<Alternative>(question.getAlternatives());
							Collections.shuffle(alts);							
						for (Alternative answerOption : alts) { %>
						<div class="radio">
							<label> 
								<input type="radio" 
									name="<%=question.getQuestionId()%>"
									value="<%=answerOption.getAlternativeId()%>" /> 
									<%=answerOption.getDescription()%>
							</label>
						</div>
						<%
							}
						%>
					</div>
					<%
						}
					%>

					<input type="submit" value="Submit answers" />

				</form><!--END of form.studentAttemptForm-->
			</div><!--END of div.col-md-12 -->
		</div><!--END of div.row -->

		<%@ include file="../shared/footer.jsp"%>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
		<script> $.validate(); </script>
	</div><!--END of div.container -->

</body>
</html>