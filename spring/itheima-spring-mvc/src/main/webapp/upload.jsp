<%--
  Created by IntelliJ IDEA.
  User: cx
  Date: 2020/9/5
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick22" enctype="multipart/form-data" method="post">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="uploadFile"><br/>
        文件2<input type="file" name="uploadFile2"><br/>

        <input type="submit" value="提交">
    </form>
</body>
</html>
