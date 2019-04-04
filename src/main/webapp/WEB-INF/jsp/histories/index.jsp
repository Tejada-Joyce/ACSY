<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.acsy.consultant.Consultant"%>
<%@ page import="com.acsy.history.History"%>
<%@ page import="com.acsy.assignment.Assignment"%>
<%@ page import="com.acsy.system.auth.AuthHelpers"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="../layouts/nav.jsp"></jsp:include>

	<%
    Consultant consultant = (Consultant)request.getAttribute("consultant");
    List<Assignment> assignments = (ArrayList<Assignment>)request.getAttribute("assignments");
  
  %>

	<div class="container">
		<div class="row">
			<h2 class="center col s12">Histories</h2>
		</div>

	</div>

	<div class="container browser-default">
		<table id="list" class="display">
			<thead>
				<tr>
					<th><a href="">Client Name</a></th>
					<th>Phone</th>
					<th>Email</th>
					<th>Group</th>
					<th col="2">Options</th>
				</tr>
			</thead>
			<tbody>
				<% 
			if (assignments != null){
			  if(AuthHelpers.authenticate_admin(request, response)){
			    for(Assignment assignment : assignments){
			    for(History history : assignment.getHistories()){
			
      %>
				<tr>
					<td><%= history.getClient().getFirstName() + " " + history.getClient().getLastName() %></td>
					<td><%= history.getClient().getPhone() %></td>
					<td><%= history.getClient().getEmail() %></td>
					<td><%= assignment.getGroup().getName() %></td>
					<td col="2"></td>
				</tr>
				<% }}} else if (AuthHelpers.authenticate_consultant(request, response)){
			      for(Assignment assignment : assignments){
			        if (assignment.isCompleted()) continue;  
			          for(History history : assignment.getHistories()){
			%>
        <tr>
          <td><%= history.getClient().getFirstName() + " " + history.getClient().getLastName() %></td>
          <td><%= history.getClient().getPhone() %></td>
          <td><%= history.getClient().getEmail() %></td>
          <td><%= assignment.getGroup().getName() %></td>
          <td col="2">
            <% if(!history.isDone()){ %>
              <a onClick="to_edit('${pageContext.request.contextPath}/histories/edit', 'history_id', <%= history.getId() %>)" href="#">Edit</a>
              <a onclick="mark_as_done('${pageContext.request.contextPath}/histories/set_done', <%= history.getId() %>)" href="#">Mark as Done</a>
            <% } else { %>
              <span class="grey">Edit</span>
              <span class="red"> Marked as Done </span>
            <% }%>
          </td>
        </tr>

				<% }}}} %>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
		    $('#list').DataTable();
		} );
		
		function mark_as_done(url, history_id){
			$('<form action="'+url+'" method="POST"/>')
            .append($('<input type="hidden" name="history_id" value="'+id+'">'))
            .appendTo($(document.body)) //it has to be added somewhere into the <body>
            .submit();
		}
		
		function to_edit(url, name, id){
			$('<form action="'+url+'" method="POST"/>')
            .append($('<input type="hidden" name="'+name+'" value="'+id+'">'))
            .appendTo($(document.body)) //it has to be added somewhere into the <body>
            .submit();
		}
	</script>
</body>

</html>
