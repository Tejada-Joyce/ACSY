<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
<title>History Form</title>
</head>

<body>
	<jsp:include page="../layouts/nav.jsp"></jsp:include>
	<h2>Client's Name</h2>
	<form action="" method="post">
		<fieldset>
			<label><span>Description:</span>
			<textarea name="description" rows="10" cols="28"></textarea></label> <label><span>Rate</span><select
				name="rate">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select></label>
		</fieldset>
		<input type="submit" value="Add History" class="submitBt">
		<%--input hidden tag with the user's id--%>

	</form>
</body>

</html>
