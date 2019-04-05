<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.system.auth.AuthHelpers" %>
<!DOCTYPE html>
<html lang="en-us">
  <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Login Form</title>
      <meta name="author" content="Joyce Tejada">
      
      <link rel="stylesheet" type="text/css" href="assets/css/datatables.css">
      <link rel="stylesheet" type="text/css" href="assets/css/materialize.css">
  </head>

  <body>	
	  <jsp:include page="WEB-INF/jsp/layouts/nav.jsp"></jsp:include>
	  <h1 class = "center-align"><%= session.getAttribute("type") != null ? session.getAttribute("type"):"Nothing" %></h1>
	  <% if(AuthHelpers.getCurrentUser(request,response) == null) { %>
	  <div class="container">
	    <h4>Sign In</h4>
			<form action="auth/Login" method="post">
			    <fieldset>		     		       
			        <label><span>Email:</span><input name="email" type="email" value="" placeholder="name123@acsy.com" required></label>
			        <label><span>Password:</span><input name="password" type="password" value="" required></label>
			    </fieldset>
			    <input type="submit" value="Login" class="submitBt">
			</form>
	  </div>
	  <% } %>
	  <script src="assets/js/jquery-3.3.1.js"></script>	
	  <script src="assets/js/datatables.js"></script>	
  </body>

</html>
