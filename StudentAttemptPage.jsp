<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
</head>
<body>
<h1>Quizzium</h1>
<hr />

<% 
	Object currentQuiz = 2; 
	// TODO currentQuiz = fetch from Controller Quiz with STATE == 1
			
	if(currentQuiz == null){
		out.print("<h3>Ooops! NO Quizz is currently availible!</h3>");
	}
	else{
		out.print("<h3>Quiz name goes here</h3>");
		//TODO replace "Quiz name goes here" with currentQuiz.name
		
		out.print("<form name=\"studentAttemptForm\" " +
					"action=\"myController\" method=\"POST\">");
		
		out.print("<div>");
			out.print("<p>Student number");
			out.print("<input type=\"text\" name=\"studentNumber\" />");
		out.print("</div>");
		
		String[] dummyQuestionList = {"What is 1?", "What is 2", "What is 3?"};
		//TODO FOR LOOP for question in Quiz.questions
		
		for(String question : dummyQuestionList){
			
			out.print("<div class=\"questionBlock\">");
				out.print("<p>" + question + "<br />");
				
				String[] dummyAnswerList = {"42", "35", "64", "12"};
				//TODO FOR LOOP for answerAlternatives in questions.answerAlternatives
				
				for(String answerOption : dummyAnswerList){
					out.print("<input type=\"radio\" name=\"" +
								question + "\" value=\"" +
								answerOption + "\" />" +
								answerOption + "<br />");
				}
				
			out.print("</div>"); //END of div.questionBlock
		}
		
		out.print("<input type=\"submit\" value=\"Submit answers\"");
		
		out.print("</form>"); // END of form.studentAttemptForm
	}
%>		

<hr />
&copy; 2014

</body>
</html>