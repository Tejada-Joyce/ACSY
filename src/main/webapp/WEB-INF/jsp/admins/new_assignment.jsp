<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.consultant.Consultant"%>
<%@ page import="com.acsy.group.Group"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="../layouts/nav.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<h2 class="center">New Assignment</h2>

		</div>
	</div>
	<% 
	  String action = (String)request.getAttribute("action");
	  String operation = (String)request.getAttribute("operation");
	%>
	<form action="${pageContext.request.contextPath}<%= action %>"
		method="post">
		<div>
			<div class="input-field">
				<select name="group_id" class="browser-default" id="select-group">
					<option value="" disabled selected>Choose Group</option>
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
		<div>
			<div class="input-field">
				<select name="consultant_id" class="browser-default" id="select-group">
					<option value="" disabled selected>Choose Consultant</option>
					<% 
				List<Consultant> consultants = (ArrayList<Consultant>)request.getAttribute("consultants");
				if (consultants != null){
				for(Consultant con : consultants){
		      %>
					<option value="<%=con.getId() %>"><%= con.getFirstName() + " " + con.getLastName()%></option>
					<% }} %>
				</select> <label>Consultant</label>
			</div>
			<input type="submit" value="Create Assignment" class="submitBt">
		</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
		    $('#select-group').formSelect();
		});
	</script>
</body>
</html>