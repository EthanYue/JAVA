<%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/26
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List</title>
</head>
<body>
Accounts<br>
<c:forEach items="${list}" var="account">
    ${account.toString()}<br>
</c:forEach>

</body>
</html>
