<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Client</title>
        <meta name="author" content="Joyce Tejada">
    </head>

    <body>
    	<nav>  
            <ul>
                <li><a href="">Client</a></li>
                <li><a href="">Consultant</a></li>
            </ul>		
        </nav>
		<h2>New Client</h2>
		<form action="" method="post">
                <fieldset>
                    <legend><span>Personal Information</span></legend>
                    <label><span>First Name:</span><input name="firstname" type="text" value="" pattern="[a-zA-Z .-_]{5,99}" placeholder="Pablo" required></label>
                    <label><span>Last Name:</span><input name="lastname" type="text" value="" pattern="[a-zA-Z .-_]{5,99}" placeholder="Chavez" required></label>
                    <label><span>Phone Number:</span><input name="phone" type="tel" value="" placeholder="51968683215" pattern="[0-9]{10,20}" required></label>
                    <label><span>Email:</span><input name="email" type="email" value="" placeholder="name123@gmail.com"></label>                    
                    <label><span>Status:</span><input name="status" type="text" value="active" pattern="[a-zA-Z .-_]{5,99}" required></label>
                    <label><span>Group ID</span><select name="group">
					    <option value="1">1</option>
					    <option value="2">2</option>
					    <option value="3">3</option>
					    <option value="4">4</option>
					    <option value="5">5</option>
					</select></label>
                </fieldset>
                <input type="submit" value="Add Client" class="submitBt">
            </form>
	</body>

</html>
