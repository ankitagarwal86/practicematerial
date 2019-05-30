<% String redirectUrl = request.getContextPath() + "/calculate"; %>

Redirecting to <a href="<%= redirectUrl %>"/><%= redirectUrl %></a>

<% response.sendRedirect(redirectUrl); %>