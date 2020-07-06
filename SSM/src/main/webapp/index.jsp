<%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/26
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">FindAccount</a><br>

<form action="/account/saveAccount">
    <input type="text" name="name" placeholder="name"><br>
    <input type="text" name="money" placeholder="money"><br>
    <input type="submit" value="submit"><br>
</form>
</body>
</html>
