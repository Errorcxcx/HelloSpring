<%--
  Created by IntelliJ IDEA.
  User: MI
  Date: 2020/9/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        var userList = new Array();
        userList.push({username: "zhangsan", age: 18}, {username: "lisi", age: 18})
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/quick15",
            data: JSON.stringify(userList),
            contentType: "application/json;charset=utf-8"
        })
        console.log(JSON.stringify(userList))
    </script>
</head>
<body>

</body>
</html>
