<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.client.Client" %>  

<div class="container">
  <% 
  Client client = (Client)request.getAttribute("client"); 
  String action = (String)request.getAttribute("action");
  String operation = (String)request.getAttribute("operation");
  %>
	<form action="${pageContext.request.contextPath}<%= action %>" method="post">
	<fieldset>
    <legend>
      <span>Personal Information</span>
    </legend>
    <div>
	  <input 
      placeholder="Marina" 
      id="first_name" 
      type="text" 
      class="validate" 
      name="first_name" 
      pattern="[a-zA-Z .-_]{3,99}"
      value="<%= client != null ? client.getFirstName() : "" %>">
    <label for="first_name">First Name</label>
    </div>
    
    <div>
    <input 
      placeholder="Ruiz" 
      id="last_name" 
      type="text" 
      class="validate" 
      name="last_name" 
      pattern="[a-zA-Z .-_]{3,99}"
      value="<%= client != null ? client.getLastName() : "" %>">
    <label for="last_name">First Name</label>
    </div>
    
    <div>
    <input 
      placeholder="51968683215" 
      id="phone" 
      type="tel" 
      class="validate" 
      name="phone" 
      pattern="[0-9]{10,20}"
      value="<%= client != null ? client.getPhone() : "" %>">
    <label for="phone">Phone</label>
    </div>
    
    <div>
    <input placeholder="name123@gmail.com" id="email" type="text" class="validate" 
    value="<%= client != null ? client.getEmail() : "" %>" name="email" required>
    <label for="first_name">Email</label>
    </div>
  <%--  
    <% if ("new".equals((String)request.getAttribute("operation"))){ %>
    <div>
    <input placeholder="password" id="password" type="text" class="validate" name="password" required>
    <label for="password">Password</label>
    </div>
    
    <div>
    <input placeholder="Password" id="password_confirm" type="text" class="validate" name="password_confirm" required>
    <label for="first_name">Confirm Password</label>
    </div>
    <% } else { %>
      <input type="hidden" name="consultant_id" value="<%= client != null ? client.getId() : "" %>">
    <% } %>
    </fieldset> --%> 
    <input type="submit" value="<%= "new".equals(operation) ? "Add Client":"Update Client" %>" class="submitBt">
	</form>
</div>
