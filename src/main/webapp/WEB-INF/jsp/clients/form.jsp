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
		<fieldset>
			<legend>
				<span>Personal Information</span>
			</legend>
			<div>
				<input placeholder="Marina" id="first_name" type="text"
					class="validate" name="first_name" pattern="[a-zA-Z .-_]{3,99}"
					value="<%= client != null ? client.getFirstName() : "" %>">
				<label for="first_name">First Name</label>
			</div>

			<div>
				<input placeholder="Ruiz" id="last_name" type="text"
					class="validate" name="last_name" pattern="[a-zA-Z .-_]{3,99}"
					value="<%= client != null ? client.getLastName() : "" %>">
				<label for="last_name">First Name</label>
			</div>

			<div>
				<input placeholder="51968683215" id="phone" type="tel"
					class="validate" name="phone"
					value="<%= client != null ? client.getPhone() : "" %>"> <label
					for="phone">Phone</label>
			</div>

			<div>
				<input placeholder="name123@gmail.com" id="email" type="text"
					class="validate"
					value="<%= client != null ? client.getEmail() : "" %>" name="email"
					required> <label for="first_name">Email</label>
			</div>
			<div>
				<div class="input-field">
					<select name="group_id" class="browser-default" id="select-group">
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

					</select> <label>Group</label>
				</div>
			</div>
			<input type="submit"
				value="<%= "new".equals(operation) ? "Add Client":"Update Client" %>"
				class="submitBt">
	</form>
</div>
<script type="text/javascript">
$(document).ready(function(){
    $('#select-group').formSelect();
  });
</script>
