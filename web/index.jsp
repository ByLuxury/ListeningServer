<%--
  Created by IntelliJ IDEA.
  User: zhoushuai
  Date: 27/03/2017
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>服务器已启动......
<form action="/RefreshServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>

    </table>
    <input type="submit" value="提交">
</form>

</body>
</html>
