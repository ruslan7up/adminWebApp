<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12.01.2017
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${action.equals('add')}">
        <title>Новое расписание</title>
    </c:if>
    <c:if test="${action.equals('edit')}">
        <title>Редактирование расписания</title>
    </c:if>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
    <style>
        table {
            float: center;
        }
    </style>
</head>
<body>
<c:if test="${action.equals('add')}">
    <%@include file="scheduleadd.jsp"%>
</c:if>
<c:if test="${action.equals('edit')}">
    <%@include file="scheduleedit.jsp"%>
</c:if>
</body>
</html>
