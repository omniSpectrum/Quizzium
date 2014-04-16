<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>
<%@ page import="omniSpectrum.Quizzium.Models.Student" %>
<%@ page import="java.util.ArrayList" %>

</head>
<body>
	<%@ include file="../shared/teacherMenu.jsp" %>

	
<div class="container">
<div class="row">
	<div class="col-md-12">
	<div class="panel panel-info">
	<div class="panel-heading">Quiz List</div>
	<table class="table table-striped">
		<tr>
			<th><!-- THIS CEll initially left blank --></th>
			<th>Quiz 1</th>
			<th>Quiz 2</th>
			<th>Quiz 3</th>
			<th>Mean</th>
		</tr>
		<tr>
			<td>a152045</td>
			<td>75</td>
			<td>65</td>
			<td>82</td>
			<td>90</td>
		</tr>
		<tr>
			<td>a652045</td>
			<td>23</td>
			<td>43</td>
			<td>32</td>
			<td>30</td>
		</tr>
	</table>
	</div>
		
	<%@ include file="../shared/footer.jsp" %>
	</div>
	</div>
</div>
</body>
</html>