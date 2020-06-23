<%@ page import="com.netease.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/7
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>User</title>
</head>
<body>
<%
    User user1 = new User(1, "yuefeiyu", "yuefeiyu", new Date());
    User user2 = new User(2, "allenyue", "yuefeiyu", new Date());
    User user3 = new User(3, "ethanyue", "yuefeiyu", new Date());
    User user4 = new User(4, "aristotle", "yuefeiyu", new Date());
    List list = new ArrayList();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    list.add(user4);
    request.setAttribute("userList", list);
%>

<table border="1" width="500" align="center">
    <tr>
        <th>Index</th>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Birthday</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="s">
        <c:if test="${s.count %2 == 0}">
            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.formatDate}</td>
            </tr>
        </c:if>

        <c:if test="${s.count %2 != 0}">
            <tr bgcolor="green">
                <td>${s.count}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.formatDate}</td>
            </tr>
        </c:if>

    </c:forEach>
</table>


</body>
</html>
