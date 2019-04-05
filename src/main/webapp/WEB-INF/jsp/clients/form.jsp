<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.client.Client"%>
<%@ page import="com.acsy.group.Group"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<div class="container">
	<% 
  Client client = (Client)request.getAttribute("client"); 
  String action = (String)request.getAttribute("action");
  String operation = (String)request.getAttribute("operation");
  %>
	<form action="${pageContext.request.contextPath}<%= action %>"
		method="post">
			<div>
			  <label for="first_name">First Name</label>
				<input placeholder="Marina" id="first_name" type="text"
					class="validate" name="first_name" pattern="[a-zA-Z .-_]{3,99}"
					value="<%= client != null ? client.getFirstName() : "" %>">
				
			</div>

			<div>
        <label for="last_name">Last Name</label>
				<input placeholder="Ruiz" id="last_name" type="text"
					class="validate" name="last_name" pattern="[a-zA-Z .-_]{3,99}"
					value="<%= client != null ? client.getLastName() : "" %>">
			</div>

			<div>
			   <label for="phone">Phone</label>
				<input placeholder="51968683215" id="phone" type="tel"
					class="validate" name="phone"
					value="<%= client != null ? client.getPhone() : "" %>">
			</div>

			<div>
			  <label for="email">Email</label>
				<input placeholder="name123@gmail.com" id="email" type="text"
					class="validate"
					value="<%= client != null ? client.getEmail() : "" %>" name="email"
					required>
			</div>
			<div>
				<div class="input-field">
					<select name="group_id" class="blue">
						<option
							value="<%= client != null ? client.getGroup().getId() : "" %>"
							disabled selected><%= client != null ? client.getGroup().getName() : "Choose your option" %></option>
						<% 
				List<Group> groups = (ArrayList<Group>)request.getAttribute("groups");
				if (groups != null){
				for(Group gr : groups){
		      %>
						<option value="<%=gr.getId() %>"><%= gr.getName()%></option>
						<% }} %>

					</select>
					<label>Group</label>
				</div>
			</div>
			<input type="submit" class="btn indigo darken-1"
				value="<%= "new".equals(operation) ? "Add Client":"Update Client" %>">
				<a class="btn" href="${pageContext.request.contextPath}/clients/index">BACK</a>
	</form>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('select').formSelect();
});
</script>
