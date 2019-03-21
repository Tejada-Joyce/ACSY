<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Form</title>
        <meta name="author" content="Joyce Tejada">
    </head>

    <body>
		<h2>Sign In</h2>
		<form action="/Login" method="post">
		    <fieldset>		     		       
		        <label><span>Email:</span><input name="email" type="email" value="" placeholder="name123@acsy.com" required></label>
		        <label><span>Password:</span><input name="password" type="password" value="" required></label>
		    </fieldset>
		    <input type="submit" value="Login" class="submitBt">
		</form>	
	</body>

</html>
