<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a href="api/movie">获取视频</a>--%>
<%--<a href="api/code">获取验证码</a>--%>
<%--<a href="api/pdf">获取笔记</a>--%>
<img src="/api/code" alt="">
<form action="/api/login" method="post">
    <label>
        <input type="text" name="code">
    </label >
    <input type="submit" value="登录">
</form>
</body>
</html>
