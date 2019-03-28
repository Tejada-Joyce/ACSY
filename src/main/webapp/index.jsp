<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">ACSY</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
      <% if( session.getAttribute("session") == null ){ %>
        <li><a href="index.jsp">Login</a></li>
      <% } else { %>
        <li><a href="collapsible.html">Logout</a></li>
      <% } %>


      </ul>
    </div>
  </nav>
  <h1><%= session.getAttribute("type") != null ? session.getAttribute("type"):"Nothing" %></h1>
  <div class="container">
    <h2>Sign In</h2>
		<form action="Login" method="post">
		    <fieldset>		     		       
		        <label><span>Email:</span><input name="email" type="email" value="" placeholder="name123@acsy.com" required></label>
		        <label><span>Password:</span><input name="password" type="password" value="" required></label>
		    </fieldset>
		    <input type="submit" value="Login" class="submitBt">
		</form>
  </div>
  <script src="assets/js/jquery-3.3.1.js"></script>	
  <script src="assets/js/datatables.js"></script>	
	</body>

</html>
