<%@page import="java.security.Principal" %>


<html>
 <head>
  <title>Testing Waffle</title>
 </head>
 <body>
  You are logged in as remote user <b><%= request.getRemoteUser() %></b> in session <b><%= session.getId() %></b>.<br>
   <br><br>
  <%
    if (request.getUserPrincipal() != null) {
  %>
  Your user principal name is <b><%= request.getUserPrincipal().getName() %></b>.
  <br><br>
  <%
   } else {
  %>
   No user principal could be identified.
   <br><br>
  <%
  }
  %>