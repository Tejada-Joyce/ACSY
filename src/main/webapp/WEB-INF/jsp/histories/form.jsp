<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.history.History" %>  

<div class="container">
  <% 
  History history = (History)request.getAttribute("history"); 
  String action = (String)request.getAttribute("action");
  String operation = (String)request.getAttribute("operation");
  %>
	<form action="${pageContext.request.contextPath}<%= action %>" method="post">
		<fieldset>
			<label><span>Description:</span>
			<textarea name="description" rows="10" cols="28"></textarea></label> <label><span>Rate</span>
			<select
				name="rate">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
			</select></label>
		</fieldset>
		<input type="submit" value="Update History" class="submitBt">
		<%--input hidden tag with the user's id--%>

	</form>
</div>
