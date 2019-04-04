<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>  
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.acsy.client.Client" %>  
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
</head>

<body>
  <jsp:include page="../layouts/nav.jsp"></jsp:include>
	
	<div class="container">
	<div class="row">
    <h2 class="center col s12 m6">Clients</h2>
    <a class="center-align waves-effect waves-light btn col s12 m6" href="new">NEW CLIENT</a>
	</div>
	
  </div>
  	
	<div class="container browser-default">
		<table id="list" class="display">
			<thead>
			<tr>
				<th><a href="">Full Name</a></th>
				<th>Phone</th>
				<th>Email</th>
				<th>Group</th>
				<%--Status --%>
				<th col="2">Options</th>
			</tr>
			</thead>
			<tbody>
			<% 
			List<Client> clients = (ArrayList<Client>)request.getAttribute("clients");
			if (clients != null){
			for(Client cl : clients){
      		%>
			<tr>
				<td><%= cl.getFirstName() + " " + cl.getLastName() %></td>
				<td><%= cl.getPhone() %></td>
				<td><%= cl.getEmail() %></td>
				<td><%= cl.getGroup().getName()%></td>
				<td col="2">
				  <a href="${pageContext.request.contextPath}<%= "/clients/edit/"+cl.getId() %>">Edit</a>
				  <a href="${pageContext.request.contextPath}<%= "/clients/delete/"+cl.getId() %>">Delete</a>
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
