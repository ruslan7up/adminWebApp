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
    <title>Чат</title>
</head>
<body>
<div id="messages"></div>
<input placeholder="YOUR NAME" id="nameofuser">
<textarea placeholder="Текст" id="text"></textarea>
<button id="sendmessage" type="submit">Отправить</button>
<script src="/resources/jquery/jquery-3.1.1.js"></script>
<script src="/resources/bootstrap/js/bootstrap.js"></script>
<script src="/resources/sockjs/sockjs-0.3.4.js"></script>
<script src="/resources/stomp/stomp.js"></script>
<script src="/resources/js/chatScripts.js"></script>
</body>

</html>
