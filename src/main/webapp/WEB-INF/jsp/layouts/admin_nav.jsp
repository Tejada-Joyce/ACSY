<nav>
  <div class="nav-wrapper">
    <a href="#" class="brand-logo">ACSY</a>
    <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="clients.jsp">Login</a></li>
      <% if( session.getAttribute("session") == null ){ %>
        <li><a href="index.jsp">Login</a></li>
      <% } else { %>
        <li><a href="collapsible.html">Logout</a></li>
      <% } %>
    </ul>
  </div>
</nav>