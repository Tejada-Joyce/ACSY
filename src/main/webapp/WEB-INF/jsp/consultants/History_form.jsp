<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>History Form</title>
        <meta name="author" content="Joyce Tejada">
    </head>

    <body>
    	<nav>  
            <ul>
                <li><a href="">My Clients</a></li>
            </ul>		
        </nav>
		<h2>Client's Name</h2>
		<form action="" method="post">
                <fieldset>                    
                    <label><span>Description:</span><textarea name="description" rows="10" cols="28"></textarea></label>
                    <label><span>Rate</span><select name="rate">
					    <option value="1">1</option>
					    <option value="2">2</option>
					    <option value="3">3</option>
					    <option value="4">4</option>
					    <option value="5">5</option>
					</select></label>
                </fieldset>
                <input type="submit" value="Add Client" class="submitBt">
                <%--input hidden tag with the user's id--%>
                
            </form>
	</body>

</html>
