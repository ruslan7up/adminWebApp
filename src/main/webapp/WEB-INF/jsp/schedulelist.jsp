<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12.01.2017
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Список расписаний</title>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
</head>
<body>
<button type="button" class="btn btn-default" id="addsched">Добавить расписание</button>
<table class="table table-bordered">
    <thead>
    <tr>
        <th><span class="fa fa-cog"></span></th>
        <th>Смена</th>
        <th>Название группы</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${schedules}" var="schedule">
        <tr>
            <td><button type="button" class="btn btn-success btn-edt" data-id="${schedule.getId()}"><span class="glyphicon glyphicon-edit"></span></button><button type="button" class="btn btn-danger btn-del" data-id="${schedule.getId()}"><span class="glyphicon glyphicon-remove"></span></button></td>
            <td>${schedule.getShift()}</td>
            <td>${schedule.getName()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<script src="/resources/jquery/jquery-3.1.1.js"></script>
<script src="/resources/bootstrap/js/bootstrap.js"></script>
<script src="/resources/js/scheduleListScripts.js"></script>
</body>
</html>