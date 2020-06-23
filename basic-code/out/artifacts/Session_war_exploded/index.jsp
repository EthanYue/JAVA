<%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/6
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP</title>
  </head>
  <body>
    <%
      System.out.println("hello"); // in service method in Servlet;
      out.print(request.getContextPath()); // out, request and so on are inner object in jsp;
    %>

    <%
      response.getWriter().write("hello"); // response.getWrite.write() will be print to html page before out();
    %>
    <%!
      int i = 3; // member var;
    %>
    <%= i%><%--    out to html page--%>
  </body>
</html>
