<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/1
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"name": "hehe", "age": 18}',
                    dataType: "json",
                    type: "post",
                    success: function(data) {
                        alert(data);
                    }
                })
            });
        });

    </script>

</head>
<body>

<%--<button id="btn">发送ajax的请求</button>--%>
Normal Upload<br>
<form action="/user/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br>
    <input type="submit" value="submit">
</form>

SpringMVC Upload<br>
<form action="/user/fileUpload2" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br>
    <input type="submit" value="submit">
</form>

<br>
<a href="/user/exceptionHandle">Exception Handle</a>

</body>
</html>
