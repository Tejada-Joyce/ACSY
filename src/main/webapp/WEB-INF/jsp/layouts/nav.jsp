<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.acsy.system.auth.AuthHelpers" %>
<%@ page import="com.acsy.admin.Admin" %>
<%@ page import="com.acsy.consultant.Consultant" %>  
    
<% if(AuthHelpers.authenticate_admin(request, response)) { %>
<nav class="light-blue" style="padding: 0 15px 0 15px">
  <div class="nav-wrapper">
    <a href="${pageContext.request.contextPath}" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="${pageContext.request.contextPath}/admins/new_assignment">Assign Group</a></li>
      <li><a href="${pageContext.request.contextPath}/clients/index">Clients</a></li>
      <li><a href="${pageContext.request.contextPath}/consultants/index">Consultants</a></li>
      <li><a href="${pageContext.request.contextPath}/groups/index">Groups</a></li>
      <li><a href="${pageContext.request.contextPath}/auth/Logout">Logout</a></li>
    </ul>
  </div>
</nav>
<% } else if(AuthHelpers.authenticate_consultant(request, response)) { %>
<nav style="padding: 0 15px 0 15px">
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="${pageContext.request.contextPath}/histories/index">My Clients</a></li>
      <li><a href="${pageContext.request.contextPath}/auth/Logout">Logout</a></li>
    </ul>
  </div>
</nav>  
<% } else { %>
<nav style="padding: 0 15px 0 15px">
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="index.jsp">Login</a></li>
    </ul>
  </div>
</nav>
<% } %>