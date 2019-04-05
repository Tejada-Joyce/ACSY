<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.group.Group"%>

<div class="container">
	<% 
  Group group = (Group)request.getAttribute("group"); 
  String action = (String)request.getAttribute("action");
  String operation = (String)request.getAttribute("operation");
  %>
	<form action="${pageContext.request.contextPath}<%= action %>"
		method="post">
		<fieldset>
			<legend>
				<span>Group Information</span>
			</legend>
			<div>
				<input placeholder="senti" id="name" type="text"
					class="validate" name="name" pattern="[a-zA-Z .-_]{3,99}"
					value="<%= group != null ? group.getName() : "" %>">
				<label for="name">Group Name</label>
			</div>

		</fieldset>
		<input type="submit"
			value="<%= "new".equals(operation) ? "Add Group":"Update Group" %>"
			class="btn indigo darken-1">
	</form>
</div>
