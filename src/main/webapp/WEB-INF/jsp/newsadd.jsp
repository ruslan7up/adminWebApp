<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 05.02.2017
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление новости</title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form id="addnewsform">
    <input type="text" id="title" name="title" placeholder="Название новости"> <br/>
    <textarea placeholder="Текст" id="newstext" name="text"></textarea><br/>
    <input type="file" name="file" id="files" multiple value="Выбрать картинки" accept=".png,.bmp,.jpg,.jpeg"><br/>
    <input type="submit" id="btnsubmit" value="Добавить новость">
</form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Текст уведомления</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${news}" var="newsitem" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${news.getTitle()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <script src="/resources/jquery/jquery-3.1.1.js"></script>
    <script src="/resources/js/newsAddScripts.js"></script>

</body>
</html>