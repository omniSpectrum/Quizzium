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
			<%-- <th>Action</th>--%>
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
				<%-- <td>
					<button type="button" class="btn btn-default btn-xs" 
							data-toggle="modal" data-target="#myModal" >Set time</button>
				</td>--%>
			</tr>
			
		<%} //End of For loop%>
	</table>
	</div>
			
	<%@ include file="../shared/footer.jsp" %>
	</div>
	</div>
</div><!-- End of container -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
		aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Set time</h4>
      </div>
      <div class="modal-body">
        <h5>Quiz name</h5>
        <span>Start</span>
        	<input type="text" name="startDate" /> 
        <br/><br/>
        <span>End</span>
        	<input type="text" name="endDate" /> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div><!-- END of Modal -->

</body>
</html>