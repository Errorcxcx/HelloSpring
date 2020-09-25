<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/login">
        姓名：<input type="text" name="username">
        密码: <input type="text" name="password">
        <input type="checkbox" value="java" name="hobbys">java
        <input type="checkbox" value="C" name="hobbys">C
        <input type="checkbox" value="C#" name="hobbys">C#

        <input type="submit">
    </form>
</div>
</body>
</html>
