<%@ page import="com.netease.domain.User" %>
<%@ page import="com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Ethan
  Date: 2020/6/7
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL</title>
</head>
<body>

<%
    request.setAttribute("name", "yuefeiyu");
    session.setAttribute("age", 23);
    User user = new User();
    user.setId(1);
    user.setUsername("yuefeiyu");
    user.setPassword("yuefeiyu");
    user.setBirthday(new Date());
    request.setAttribute("user", user);
    List arrayList = new ArrayList();
    arrayList.add("aaa");
    arrayList.add("bbb");
    request.setAttribute("list", arrayList);
    Map map = new HashMap();
    map.put("name", "yuefeiyu");
    map.put("age", 18);
    request.setAttribute("map", map);
%>

${ 3>4 }<br>
\${ 3>4 }
<hr>
${3 + 4}<br>
${3 div 4}<br>
${3 mod 4}<br>
<hr>
${true and false}<br>
${true or false}<br>
${true or false}<br>
<hr>
${ empty "" }<br>
${ not empty "" }<br>
${ empty list}<br>
${ empty map}<br>
<hr>
${requestScope.name}<br>
${sessionScope.age}<br>
${sessionScope.age1}<br>
<hr>
${user.id}<br>
${requestScope.user.username}<br>
${user.birthday.toString()}<br>
${user.birthday.month}<br>
${user.formatDate}<br>
<hr>
${list}<br>
${list[0]}<br>
${list[2]}<br>  <%-- index out of range exception will be ignore, output is empty String--%>
<hr>
${map}<br>
${map["name"]}<br>
${map.age}<br>
<hr>
${pageContext}<br>
${pageContext.request}<br>
${pageContext.request.contextPath}<br>
</body>
</html>
