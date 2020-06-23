<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/6
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    response.setCharacterEncoding("utf-8");
    Cookie[] cookies = request.getCookies();
    String lastTime = null;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("lastTime".equals(cookie.getName())) {
                lastTime = cookie.getValue();
                break;
            }
        }
    }
    System.out.println(lastTime);
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String updateTime = simpleDateFormat.format(date);
    System.out.println(updateTime);
    updateTime = URLEncoder.encode(updateTime, "utf-8");
    Cookie lastTimeCookie = new Cookie("lastTime", updateTime);
    lastTimeCookie.setMaxAge(60 * 60 * 24 * 30);
    response.addCookie(lastTimeCookie);
    if (lastTime != null) {
        String lastTimeDecode = URLDecoder.decode(lastTime, "utf-8");
    %>
        <h1>Welcome Back, Last Login is: <%=lastTimeDecode%></h1>
    <%
    } else {
    %>
        <h1>Welcome</h1>
    <%
    }
    %>
</body>
</html>
