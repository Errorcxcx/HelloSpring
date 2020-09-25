<html>
<body>
<h2>Hello World!</h2>
<%--pageContext.request.contextPath代表当前项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
