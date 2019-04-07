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
			<h4 class="center">New Assignment</h4>

		</div>
	</div>
	<% 
	  String action = (String)request.getAttribute("action");
	  String operation = (String)request.getAttribute("operation");
	%>
	<div class="container row">
	<form action="${pageContext.request.contextPath}<%= action %>"
		method="post">
		<div>
			<div class="input-field col s12 m6">
				<select name="group_id" id="select-group">
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
			<div class="input-field col s12 m6">
				<select name="consultant_id" id="select-group">
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
			<input type="submit" value="Create Assignment" class="btn">
		</div>
	</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
		    $('select').formSelect();
		});
	</script>
</body>
</html>