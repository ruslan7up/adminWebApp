<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12.01.2017
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправить уведомление</title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<textarea placeholder="Текст уведомления" id="notificationtext"></textarea>
<div class="result"></div>
<button type="submit" id="sendnotify">Отправить уведомление!</button>
<script src="/resources/jquery/jquery-3.1.1.js"></script>
<script src="/resources/js/notificationScripts.js"></script>
</body>
</html>
