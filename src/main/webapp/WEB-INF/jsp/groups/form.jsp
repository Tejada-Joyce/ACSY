<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.group.Group"%>

<div class="container">
	<% 
  Group group = (Group)request.getAttribute("group"); 
  String action = (String)request.getAttribute("action");
  String operation = (String)request.getAttribute("operation");
  %>
	<form id="form" action="${pageContext.request.contextPath}<%= action %>"
		method="post">
		<fieldset>
			<legend>
				<span>Group Information</span>
			</legend>
			<div>
				<input placeholder="senti" id="name" type="text" class="validate"
					name="name" pattern="[a-zA-Z .-_]{3,99}"
					value="<%=group != null ? group.getName() : ""%>"> <label for="name">Group Name</label>	
				<input type="hidden" name="group_id" value="<%= group != null ? group.getId() : "" %>">					
			</div>
		</fieldset>
		<input type="submit"
			value="<%= "new".equals(operation) ? "Add Group":"Update Group" %>"
			class="btn indigo darken-1">
	</form>
</div>

<script>
$('#form').submit((event) => {
	event.preventDefault();
	var data = {name: $('#name').val()};
	var JSON_data = JSON.stringify(data);
	
	$.ajax({
		type: "POST",
		url: ${pageContext.request.contextPath} + '<%= action %>',
		data: JSON_data,
		success: (response)=>{
			alert(response.message);
			window.location.href = ${pageContext.request.contextPath} + '/groups/index';
		},
		dataType: 'application/json',
	})
});
</script>