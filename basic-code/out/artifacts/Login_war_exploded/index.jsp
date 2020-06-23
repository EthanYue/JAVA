<%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/5/30
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp" %>
<html>
<head>
    <title>Tomcat</title>

  <script>
    window.onload = function () {
      document.getElementById("img").onclick = function () {
        this.src="/Login_war_exploded/checkCode?time=" + new Date().getTime();
      }
    }
  </script>

  <style>
    div {
      color: red;
    }
  </style>

</head>
<body>
<form action="/Login_war_exploded/login" method="post">
  <table>
    <tr>
      <td>Username:</td>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td>CheckCode:</td>
      <td><input type="text" name="checkCode"></td>
    </tr>
    <tr>
      <td colspan="2"><img id="img" src="/Login_war_exploded/checkCode"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Login"></td>
    </tr>
  </table>
</form>

<%--<div><%=request.getAttribute("checkCode_msg") == null ? "" : request.getAttribute("checkCode_msg")%></div>--%>
<%--<div><%=request.getAttribute("user_msg") == null ? "" : request.getAttribute("user_msg")%></div>--%>

${requestScope.checkCode_msg}<br>
${requestScope.user_msg}

</body>
</html>
