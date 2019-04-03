<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>  
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.acsy.consultant.Consultant" %>  
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
</head>

<body>
  <jsp:include page="../layouts/nav.jsp"></jsp:include>
	
	<div class="container">
	<div class="row">
    <h2 class="center col s12 m6">Consultants</h2>
    <a class="center-align waves-effect waves-light btn col s12 m6" href="new">NEW CONSULTANT</a>
	</div>
	
  </div>
  	
	<div class="container browser-default">
		<table id="list" class="display">
			<thead>
			<tr>
				<th><a href="">Full Name</a></th>
				<th>Phone</th>
				<th>Email</th>
				<th col="2">Options</th>
			</tr>
			</thead>
			<tbody>
			<% 
			List<Consultant> consultants = (ArrayList<Consultant>)request.getAttribute("consultants");
			if (consultants != null){
			for(Consultant cons : consultants){
      %>
			<tr>
				<td><%= cons.getFirstName() + " " + cons.getLastName() %></td>
				<td><%= cons.getPhone() %></td>
				<td><%= cons.getEmail() %></td>
				<td col="2">
				  <a href="${pageContext.request.contextPath}<%= "/consultants/edit/"+cons.getId() %>">Edit</a>
				  <a href="${pageContext.request.contextPath}<%= "/consultants/delete/"+cons.getId() %>">Delete</a>
				</td>
			</tr>
			<% }} %>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#list').DataTable();
		} );
	</script>
</body>

</html>
