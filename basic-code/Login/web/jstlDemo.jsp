<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/7
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list", list);

    request.setAttribute("number", 6);
%>

<h1>if</h1>
<c:if test="${not empty list}">
    <h3>List is not empty</h3>
</c:if>
<c:if test="${empty list}">
    <h3>List is empty</h3>
</c:if>
<hr>

<h1>choose</h1>
<c:choose>
    <c:when test="${number == 4}">Thursday</c:when>
    <c:when test="${number == 5}">Friday</c:when>
    <c:otherwise>Wrong Number</c:otherwise>
</c:choose>
<hr>

<h1>foreach</h1>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>
<hr>
<c:forEach items="${list}" var="i" varStatus="s">
    ${i} ${s.index} ${s.count}<br>
</c:forEach>
</body>
</html>
