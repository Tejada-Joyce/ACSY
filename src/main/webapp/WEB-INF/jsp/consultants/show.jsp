<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.consultant.Consultant" %>  
<%@ page import="com.acsy.assignment.Assignment" %>
<%@ page import="com.acsy.history.History" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../layouts/header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
 <% 
  Consultant consultant = (Consultant)request.getAttribute("consultant");
  String action = (String)request.getAttribute("action");
  String operation = (String)request.getAttribute("operation");
  List<Assignment> assignments =  (ArrayList<Assignment>)request.getAttribute("assignments"); 
  %>
<jsp:include page="../layouts/nav.jsp"></jsp:include>
<div class="container browser-default">
		<table id="list" class="display">
			<thead>
			<tr>
				<th><a href="">Name</a></th>
				<th>Description</th>
				<th>Rate</th>
				<th>Completed</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
			if (assignments != null){
			for(Assignment assignment : assignments){
				if(assignment.getHistories()!= null){
					for(History history: assignment.getHistories()){						
								
      		%>
			<tr>
				<td><%= history.getDescription()%></td>
				<td><%= history.getRate() %></td>
				<td><%= history.isDone() %></td>				
			</tr>
			<% }}}} %>
			</tbody>
		</table>
	</div>
</body>
</html>