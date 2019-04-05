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
	<div>
  <h4 class="center">Consultants</h4></div>
  <a class="center-align btn indigo darken-1" href="new">NEW CONSULTANT</a>
	
  </div>
  	
	<div class="container browser-default">
		<table id="list" class="display">
			<thead>
			<tr>
				<th>Full Name</th>
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
				<td><a href="#" onClick="to_show('${pageContext.request.contextPath}/consultants/show', 'consultant_id', <%= cons.getId() %>)"><%= cons.getFirstName() + " " + cons.getLastName() %></a></td>
				<td><%= cons.getPhone() %></td>
				<td><%= cons.getEmail() %></td>
				<td col="2">
				  <a onClick="to_edit('${pageContext.request.contextPath}/consultants/edit', 'consultant_id', <%= cons.getId() %>)" href="#">Edit</a> 
				  <a onClick="to_delete('${pageContext.request.contextPath}/consultants/delete', 'consultant_id', <%= cons.getId() %>)" href="#">Delete</a> 
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
		
		function to_show(url, name, id){
			$('<form action="'+url+'" method="POST"/>')
	          .append($('<input type="hidden" name="'+name+'" value="'+id+'">'))
	          .appendTo($(document.body)) //it has to be added somewhere into the <body>
	          .submit();
			//var data = ''+name+'='+id;
			//$.post( url, { consultant_id : id });
			/*$.ajax({
				  type: "POST",
				  url: url,
				  data: data
				  headers: {
			            'Content-Type': 'application/x-www-form-urlencoded'
			    },
				});*/
			//var formData = new FormData();
			
      //formData.append(name, id);
      /*fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: data
      });*/
    }
		function to_edit(url, name, id){
			$('<form action="'+url+'" method="POST"/>')
            .append($('<input type="hidden" name="'+name+'" value="'+id+'">'))
            .appendTo($(document.body)) //it has to be added somewhere into the <body>
            .submit();
		}
		
		function to_delete(url, name, id){
			$('<form action="'+url+'" method="POST"/>')
            .append($('<input type="hidden" name="'+name+'" value="'+id+'">'))
            .appendTo($(document.body)) //it has to be added somewhere into the <body>
            .submit();
		}
		
	</script>
</body>

</html>
