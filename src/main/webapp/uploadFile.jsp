<%--
  Created by IntelliJ IDEA.
  User: AKPhone
  Date: 2020/7/29
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="account/upload" method="post" enctype="multipart/form-data">
    文件描述：<input type="text" name="desc"><br>
    文件：<input type="file" name="multipartFile"><br>
    <input type="submit" value="上传">
</form>

</body>
</html>
