<%@ page import="com.netease.domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/5/30
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" %>
<html>
<head>
    <title>Success</title>

</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<h1><%=user.getUsername() %>, Welcome</h1>
</body>
</html>
