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
			<label><span>Description:</span>
			<textarea name="description" rows="10" cols="28"><%= history.getDescription() != null ? history.getDescription() : "" %></textarea></label> <label><span>Rate</span>
			<select
				name="rate">
					<option value="1" <%= history.getRate() == 1 ? "selected" : "" %>>1</option>
					<option value="2" <%= history.getRate() == 2 ? "selected" : "" %>>2</option>
					<option value="3" <%= history.getRate() == 3 ? "selected" : "" %>>3</option>
					<option value="4" <%= history.getRate() == 4 ? "selected" : "" %>>4</option>
					<option value="5" <%= history.getRate() == 5 ? "selected" : "" %>>5</option>
			</select></label>
		<input type="hidden" name="history_id" value="<%= history.getId() %>">
		<input type="submit" value="Update History" class="btn indigo darken-1">
		<%--input hidden tag with the user's id--%>

	</form>
</div>
