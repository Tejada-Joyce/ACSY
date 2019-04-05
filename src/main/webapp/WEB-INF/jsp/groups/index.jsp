<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.acsy.group.Group"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="../layouts/nav.jsp"></jsp:include>

	<div class="container">
		<div>
  <h4 class="center">Groups</h4></div>
  <a class="center-align btn indigo darken-1" href="new">NEW GROUP</a>

	</div>

	<div class="container browser-default">
		<table id="list" class="display">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Status</th>
					<th col="2">Options</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Group> groups = (ArrayList<Group>) request.getAttribute("groups");
					if (groups != null) {
						for (Group gr : groups) {
				%>
				<tr>
					<td><%=gr.getId()%></td>
					<td><%=gr.getName()%></td>
					<td><%=gr.isStatus() %></td>
					<td col="2"><a
						href="${pageContext.request.contextPath}<%= "/groups/edit/"+gr.getId() %>">Edit</a>
						<a
						href="${pageContext.request.contextPath}<%= "/groups/delete/"+gr.getId() %>">Delete</a>
					</td>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#list').DataTable();
		});
	</script>
</body>

</html>
