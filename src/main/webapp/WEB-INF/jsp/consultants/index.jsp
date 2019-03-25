<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
</head>

<body>
  <jsp:include page="../layouts/nav.jsp"></jsp:include>
	
	<h2>My Clients</h2>
	
	<div class="container browser-default">
		<table id="list" class="display">
			<thead>
			<tr>
				<th><a href="">Full Name</a></th>
				<th>Phone</th>
				<th>Email</th>
				<th>Status</th>
				<th>Group ID</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td><a href="">Add History</a></td>
			</tr>
			<tr>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td><a href="">Add History</a></td>
			</tr>
			<tr>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td><a href="">Add History</a></td>
			</tr>
			<tr>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td><a href="">Add History</a></td>
			</tr>
			<tr>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td>placeholder</td>
				<td><a href="">Add History</a></td>
			</tr>
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
