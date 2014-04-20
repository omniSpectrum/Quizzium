<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzium</title>
<%@ include file="../shared/headContent.jsp" %>
<link rel="stylesheet" href="/Quizzium/res/css/signin.css" />
</head>
<body>

<% String mess = (String)(request.getAttribute("LoginMessage")); %>

    <div class="container">

      <form class="form-signin" role="form" action="Login" method="POST">
        <h2 class="form-signin-heading">Please Log in</h2>
        <input name="username" type="text" class="form-control" 
        		placeholder="Username" required autofocus
        		data-validation="custom" 
				data-validation-regexp="^[a-zA-Z0-9]{3,15}$"
				data-validation-error-msg="Only letters and digits"
				/>
        <input name="password" type="password" class="form-control" 
        		placeholder="Password" required 
        		data-validation="custom" 
				data-validation-regexp="^[a-zA-Z0-9]{3,15}$"
				data-validation-error-msg="Only letters and digits"
				/>      
				
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        <%= (mess != null? ("<h4>" +  mess) : "") %>
      </form>

    </div> <!-- /container -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 	<script type="text/javascript" src="/Quizzium/res/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
	<script> 
		$.validate({
			validateOnBlur : false
		}); 
	</script>

</body>
</html>

