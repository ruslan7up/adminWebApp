<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12.01.2017
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Расписание звонков</title>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
</head>
<body>
<button type="button" class="btn btn-default" id="updbtt">Обновить расписание звонков</button>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Номер пары</th>
        <th>Начало пары</th>
        <th>Конец пары</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${belltime}" var="belltime" varStatus="loop">
        <tr>
            <td class="classn">${loop.index+1}</td>
            <td class="classst"><input type="time" value="${belltime.getStartTime()}"></td>
            <td class="classet"><input type="time" value="${belltime.getEndTime()}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="/resources/jquery/jquery-3.1.1.js"></script>
<script src="/resources/bootstrap/js/bootstrap.js"></script>
<script src="/resources/js/bellTimeScripts.js"></script>
</body>
</html>
