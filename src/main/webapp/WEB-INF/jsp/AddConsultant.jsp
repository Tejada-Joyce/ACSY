<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Consultant</title>
        <meta name="author" content="Joyce Tejada">
    </head>

    <body>
    	<nav>  
            <ul>
                <li><a href="">Client</a></li>
                <li><a href="">Consultant</a></li>
            </ul>		
        </nav>
		<h2>New Consultant</h2>
		<form action="" method="post">
                <fieldset>
                    <legend><span>Personal Information</span></legend>
                    <label><span>First Name:</span><input name="firstname" type="text" value="" pattern="[a-zA-Z .-_]{5,99}" placeholder="Pablo" required></label>
                    <label><span>Last Name:</span><input name="lastname" type="text" value="" pattern="[a-zA-Z .-_]{5,99}" placeholder="Chavez" required></label>
                    <label><span>Phone Number:</span><input name="phone" type="tel" value="" placeholder="51968683215" pattern="[0-9]{10,20}" required></label>
                    <label><span>Email:</span><input name="email" type="email" value="" placeholder="name123@acsy.com" required></label>                    
                    <label><span>Password:</span><input name="password" type="password" value="" required></label>
                </fieldset>
                <input type="submit" value="Add Consultant" class="submitBt">
            </form>
	</body>

</html>