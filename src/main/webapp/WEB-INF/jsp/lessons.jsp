<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 24.05.2017
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Замены</title>
</head>
<body>
<h1>Добавить замену</h1>
<input type="date" id="date">
<input type="text" id="group" placeholder="Название группы">
<input text="text" id="lesson1" placeholder="Заменяемый предмет">
<input text="text" id="lesson2" placeholder="На что заменяется">
<input type="button" id="submitbtn" value="Добавить">
<hr>
<h1>Поиск замен</h1>
<input type="date" id="searchdate">
<table border="1">
    <thead>
        <tr>
            <td>Удаление</td>
            <td>Название группы</td>
            <td>Заменяемый предмет</td>
            <td>На что заменяется</td>
        </tr>
    </thead>

    <tbody>

    </tbody>
</table>
<script src="/resources/jquery/jquery-3.1.1.js"></script>
<script src="/resources/js/lessonsScripts.js"></script>

</body>

</html>
