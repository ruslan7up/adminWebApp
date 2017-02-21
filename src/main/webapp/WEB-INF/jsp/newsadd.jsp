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
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
</head>
<body>
    <input type="text" id="title" name="title" placeholder="Название новости"> <br/>
    <textarea placeholder="Текст" id="newstext" name="text"></textarea><br/>
    <input type="file" name="file" id="files" multiple value="Выбрать картинки" accept=".png,.bmp,.jpg,.jpeg"><br/>
    <input type="submit" id="btnsubmit" value="Добавить новость">
    <hr>
    <h3>Последние 10 новостей</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th><span class="fa fa-cog"></span></th>
            <th>Название новости</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${news}" var="newsitem" varStatus="loop">
            <tr>
                <td><button type="button" class="btn btn-danger btn-del" data-id="${newsitem.getId()}"><span class="glyphicon glyphicon-remove"></span></button></td>
                <td>${newsitem.getTitle()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <script src="/resources/jquery/jquery-3.1.1.js"></script>
    <script src="/resources/js/newsAddScripts.js"></script>

</body>
</html>