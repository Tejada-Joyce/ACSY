<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.system.auth.AuthHelpers" %>
<%@ page import="com.acsy.admin.Admin" %>
<%@ page import="com.acsy.consultant.Consultant" %>  
    
<% if(AuthHelpers.getCurrentUser(request, response) instanceof Admin) { %>
<nav>
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="#">Clients</a></li>
      <li><a href="#">Consultants</a></li>
      <li><a href="#">Groups</a></li>
      <li><a href="#">Logout</a></li>
    </ul>
  </div>
</nav>
<% } else if(AuthHelpers.getCurrentUser(request, response) instanceof Consultant) { %>
<nav>
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="#">My Clients</a></li>
      <li><a href="#">Logout</a></li>
    </ul>
  </div>
</nav>  
<% } else { %>
<nav>
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="index.jsp">Login</a></li>
    </ul>
  </div>
</nav>
<% } %>